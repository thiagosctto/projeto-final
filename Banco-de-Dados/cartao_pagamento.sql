CREATE TABLE Pagamentos (
    id Serial PRIMARY KEY,
    nome_no_cartao VARCHAR(100) NOT NULL,
    numero_do_cartao INTEGER(16) NOT NULL,
    data_validade CHAR(7) NOT NULL, 
    cvv INTEGER(4) NOT NULL
);