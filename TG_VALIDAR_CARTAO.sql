CREATE TRIGGER validar_pagamento_trigger
BEFORE INSERT OR UPDATE
ON Pagamentos
FOR EACH ROW
EXECUTE FUNCTION validar_cartao();
