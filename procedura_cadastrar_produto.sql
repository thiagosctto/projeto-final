create or replace procedure cadastrarJogo(nome varchar, descricao varchar, categoria varchar, preco numeric, fabricante varchar)
language plpgsql
as $$
begin 
	insert into produto(nome_produto,descricao,categoria,preco_base,fabricante)
	values(nome,descricao,categoria,preco,fabricante);

end $$;

--chamada da procedure
call cadastrarJogo('fifa 2','jogo de futebol','esportes',209.99,'EA');
--conferencia dos valores
select * from produto;