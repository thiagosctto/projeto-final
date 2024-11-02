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
    genero VARCHAR(10) not null,
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


SELECT current_user;

SELECT user;

select * from contas c 

ALTER TABLE contas
ADD CONSTRAINT contas_genero_check
CHECK (genero IN ('masculino', 'feminino'));

