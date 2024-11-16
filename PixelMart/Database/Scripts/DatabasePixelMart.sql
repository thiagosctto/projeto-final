SELECT pid, usename, application_name, client_addr, state
FROM pg_stat_activity
WHERE datname = 'pixelmart';

SELECT pg_terminate_backend(pid)
FROM pg_stat_activity
WHERE datname = 'pixelmart';

DROP DATABASE pixelmart;

create database PixelMart;

drop table contas 

CREATE TABLE contas (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    cpf CHAR(20) UNIQUE NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    senha VARCHAR(100) NOT NULL
);


CREATE TABLE logins (
    id SERIAL PRIMARY KEY,
    usuario VARCHAR(100) UNIQUE NOT NULL,
    senha VARCHAR(100) NOT NULL,
    ultimo_login TIMESTAMP
);


CREATE TABLE Pagamentos (
    id Serial PRIMARY KEY,
    nome_no_cartao VARCHAR(100) NOT NULL,
    numero_do_cartao VARCHAR(20) NOT NULL,
    data_validade CHAR(30) NOT NULL, 
    cvv CHAR(5) NOT NULL
);

select * from pagamentos p 


SELECT current_user;

SELECT user;

select * from contas c

select * from logins l 

drop table pagamentos 


ALTER TABLE contas
ALTER COLUMN email TYPE VARCHAR(255);  -- Aumenta o limite do email
ALTER COLUMN nome TYPE VARCHAR(255);   -- Aumenta o limite do nome
ALTER COLUMN senha TYPE VARCHAR(255);  -- Aumenta o limite da senha


ALTER TABLE contas
ADD CONSTRAINT contas_genero_check
CHECK (genero IN ('masculino', 'feminino'));

