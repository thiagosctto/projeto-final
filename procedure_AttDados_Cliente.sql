create or replace procedure atualizarDadosCliente(cliid integer,enderecoAtt varchar,telefoneAtt varchar,emailAtt varchar,cidade_clienteAtt varchar)
LANGUAGE plpgsql
AS $$
BEGIN
    UPDATE cliente_final
    SET 
        endereco = COALESCE(enderecoAtt, endereco),  
        telefone = COALESCE(telefoneAtt, telefone), 
        email = COALESCE(emailAtt, email),           
        cidade_cliente = COALESCE(cidade_clienteAtt, cidade_cliente) 
    WHERE id_cliente = cliid;

END;
$$;

--chamada da procedure
call atualizarDadosCliente(1,'rua diferente',null,'thiago@thiagooo.com',null);
--conferencia dos valores
select * from cliente_final;

