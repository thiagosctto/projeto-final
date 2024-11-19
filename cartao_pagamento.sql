CREATE TABLE Pagamentos (
    id Serial PRIMARY KEY,
    nome_no_cartao VARCHAR(100) NOT NULL,
    numero_do_cartao VARCHAR(20) NOT NULL,
    data_validade CHAR(7) NOT NULL, 
    cvv CHAR(4) NOT NULL
);