CREATE USER admin WITH PASSWORD 'admin';
GRANT ALL ON DATABASE "Pixel_Mart" TO admin;

CREATE USER consultor WITH PASSWORD 'consultor';
GRANT SELECT ON TABLE produto TO consultor;

CREATE USER lojista WITH PASSWORD 'lojista';
GRANT INSERT ,UPDATE, DELETE ON TABLE produto TO lojista;

CREATE USER suporte WITH PASSWORD 'suporte';
GRANT SELECT ON TABLE produto, pedido, entrega, estoque, suporte_cliente, devolucao TO suporte;