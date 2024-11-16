CREATE OR REPLACE FUNCTION validar_cartao()
RETURNS TRIGGER AS $$
DECLARE
    mes_validade INT;
    ano_validade INT;
BEGIN
    -- Verificar se o número do cartão contém apenas dígitos
    IF NOT (NEW.numero_do_cartao ~ '^\d+$') THEN
        RAISE EXCEPTION 'O número do cartão deve conter apenas dígitos.';
    END IF;

    -- Verificar o algoritmo de Luhn
    IF NOT validar_luhn(NEW.numero_do_cartao) THEN
        RAISE EXCEPTION 'O número do cartão é inválido (falha no algoritmo de Luhn).';
    END IF;

    -- Verificar se a data de validade está no formato MM/YYYY
    IF NOT (NEW.data_validade ~ '^\d{2}/\d{4}$') THEN
        RAISE EXCEPTION 'A data de validade deve estar no formato MM/YYYY.';
    END IF;

    -- Verificar se a data de validade é futura
    mes_validade := CAST(SUBSTRING(NEW.data_validade FROM 1 FOR 2) AS INT);
    ano_validade := CAST(SUBSTRING(NEW.data_validade FROM 4 FOR 4) AS INT);

    IF (ano_validade < EXTRACT(YEAR FROM CURRENT_DATE)) OR
       (ano_validade = EXTRACT(YEAR FROM CURRENT_DATE) AND mes_validade < EXTRACT(MONTH FROM CURRENT_DATE)) THEN
        RAISE EXCEPTION 'O cartão está expirado.';
    END IF;

    -- Verificar se o CVV contém apenas dígitos e possui 3 ou 4 caracteres
    IF NOT (NEW.cvv ~ '^\d{3,4}$') THEN
        RAISE EXCEPTION 'O CVV deve conter 3 ou 4 dígitos.';
    END IF;

    RETURN NEW; -- Permite a operação se todas as validações forem bem-sucedidas
END;
$$ LANGUAGE plpgsql;
