-- Caso existam as determinadas tabelas antes, elas irão ser dropadas.
DROP TABLE IF EXISTS suporte_cliente CASCADE;
DROP TABLE IF EXISTS devolucao CASCADE;
DROP TABLE IF EXISTS entrega CASCADE;
DROP TABLE IF EXISTS faturamento CASCADE;
DROP TABLE IF EXISTS pedido CASCADE;
DROP TABLE IF EXISTS estoque CASCADE;
DROP TABLE IF EXISTS catalogo_de_produtos CASCADE;
DROP TABLE IF EXISTS cliente_final CASCADE;
DROP TABLE IF EXISTS produto CASCADE;
DROP TABLE IF EXISTS lojas_Fornecedoras CASCADE;


CREATE TABLE catalogo_de_produtos (
  ID_Catalogo             SERIAL NOT NULL, 
  ID_Produto              int4 NOT NULL, 
  ID_Loja                 int4 NOT NULL, 
  Preco                   numeric(10, 2) NOT NULL, 
  data_inclusao           date NOT NULL, 
  lojas_FornecedorID_Loja int4 NOT NULL, 
  produtoID_produto       int4 NOT NULL, 
  PRIMARY KEY (ID_Catalogo)
);
COMMENT ON TABLE catalogo_de_produtos IS 'Catálogo de produtos da loja/empresa';
COMMENT ON COLUMN catalogo_de_produtos.ID_Catalogo IS 'Identificador único do catálogo.';
COMMENT ON COLUMN catalogo_de_produtos.ID_Produto IS 'Referência ao produto.';
COMMENT ON COLUMN catalogo_de_produtos.ID_Loja IS 'Referência à loja fornecedora.';
COMMENT ON COLUMN catalogo_de_produtos.Preco IS 'Preço do produto no catálogo.';
COMMENT ON COLUMN catalogo_de_produtos.data_inclusao IS 'Data de inclusão do produto no catálogo.';

CREATE TABLE cliente_final (
  ID_cliente     SERIAL NOT NULL, 
  nome_cliente   varchar(50) NOT NULL, 
  endereco       varchar(120) NOT NULL, 
  telefone       varchar(15) NOT NULL, 
  email          varchar(120) NOT NULL UNIQUE, 
  CPF            varchar(20) NOT NULL UNIQUE, 
  data_nasc      date NOT NULL, 
  cidade_cliente varchar(200) NOT NULL, 
  sexo_cliente   char(1) NOT NULL CHECK (sexo_cliente IN ('M', 'F', 'N')), 
  PRIMARY KEY (ID_cliente)
);
COMMENT ON TABLE cliente_final IS 'Cliente final do produto';
COMMENT ON COLUMN cliente_final.ID_cliente IS 'Identificador único do cliente';
COMMENT ON COLUMN cliente_final.nome_cliente IS 'Nome do cliente';
COMMENT ON COLUMN cliente_final.endereco IS 'Endereço do cliente';
COMMENT ON COLUMN cliente_final.telefone IS 'Telefone do cliente';
COMMENT ON COLUMN cliente_final.email IS 'Email do cliente';
COMMENT ON COLUMN cliente_final.CPF IS 'CPF do cliente';
COMMENT ON COLUMN cliente_final.data_nasc IS 'Data de nascimento do cliente final';
COMMENT ON COLUMN cliente_final.cidade_cliente IS 'Cidade onde reside o cliente';
COMMENT ON COLUMN cliente_final.sexo_cliente IS 'Sexo do(a) cliente

M -> Masculino
F -> Feminino
N -> Não desejo especificar';

CREATE TABLE devolucao (
  ID_devolucao    SERIAL NOT NULL, 
  pedidoID_pedido int4 NOT NULL, 
  data_devolucao  date NOT NULL, 
  motivo_devol    varchar(255), 
  quant_devol     int4 NOT NULL, 
  PRIMARY KEY (ID_devolucao)
);
COMMENT ON TABLE devolucao IS 'Tabela com o intuito de administrar as devoluções referentes a itens danificados durante a entrega, enviados errado ou que não satisfizeram o cliente.';
COMMENT ON COLUMN devolucao.ID_devolucao IS 'ID da devolução do pedido, visando identificar o mesmo.';
COMMENT ON COLUMN devolucao.data_devolucao IS 'Data da devolução do pedido';
COMMENT ON COLUMN devolucao.motivo_devol IS 'Motivo da devolução';
COMMENT ON COLUMN devolucao.quant_devol IS 'Quantidade de produtos devolvidos';

CREATE TABLE entrega (
  ID_entrega       SERIAL NOT NULL, 
  ID_pedido        int4 NOT NULL, 
  data_envio       date NOT NULL, 
  data_entrega     date NOT NULL, 
  status_entrega   varchar(50) NOT NULL, 
  metodo_entrega   varchar(50) NOT NULL, 
  pedidoID_pedido  int4 NOT NULL, 
  pedidoID_pedido2 int4, 
  PRIMARY KEY (ID_entrega)
);
COMMENT ON TABLE entrega IS 'Entrega do produto';
COMMENT ON COLUMN entrega.ID_entrega IS 'Identificador único da entrega';
COMMENT ON COLUMN entrega.ID_pedido IS 'Referência ao pedido';
COMMENT ON COLUMN entrega.data_envio IS 'Data de envio do pedido';
COMMENT ON COLUMN entrega.data_entrega IS 'Data de entrega do pedido';
COMMENT ON COLUMN entrega.status_entrega IS 'Status da entrega';
COMMENT ON COLUMN entrega.metodo_entrega IS 'Método utilizado para entrega';

CREATE TABLE estoque (
  ID_estoque              SERIAL NOT NULL, 
  ID_produto              int4 NOT NULL, 
  ID_loja                 int4 NOT NULL, 
  qtd_disponivel          int4, 
  lojas_FornecedorID_Loja int4 NOT NULL, 
  PRIMARY KEY (ID_estoque)
);
COMMENT ON TABLE estoque IS 'Tabela destinada ao estoque da empresa';
COMMENT ON COLUMN estoque.ID_estoque IS 'Identificador único do estoque';
COMMENT ON COLUMN estoque.ID_produto IS 'Referência ao produto';
COMMENT ON COLUMN estoque.ID_loja IS 'Referência à loja fornecedora';
COMMENT ON COLUMN estoque.qtd_disponivel IS 'Quantidade disponível em estoque';

CREATE TABLE faturamento (
  ID_faturamento   SERIAL NOT NULL, 
  ID_pedido        int4 NOT NULL, 
  valor_total      numeric(10, 2) NOT NULL, 
  data_faturamento date NOT NULL, 
  pedidoID_pedido  int4 NOT NULL, 
  PRIMARY KEY (ID_faturamento)
);
COMMENT ON TABLE faturamento IS 'Faturamento da loja';
COMMENT ON COLUMN faturamento.ID_faturamento IS 'Identificador único do faturamento';
COMMENT ON COLUMN faturamento.ID_pedido IS 'Referência ao pedido';
COMMENT ON COLUMN faturamento.valor_total IS 'Valor total do faturamento';
COMMENT ON COLUMN faturamento.data_faturamento IS 'Data do faturamento';

CREATE TABLE lojas_Fornecedoras (
  ID_Loja   SERIAL NOT NULL, 
  Nome_Loja varchar(80) NOT NULL, 
  Endereco  varchar(80) NOT NULL, 
  Telefone  varchar(15) NOT NULL, 
  Email     varchar(50) NOT NULL UNIQUE, 
  CNPJ      varchar(20) NOT NULL UNIQUE, 
  PRIMARY KEY (ID_Loja)
);
COMMENT ON TABLE lojas_Fornecedoras IS 'Lojas que fornecem os produtos para a PixelMart';
COMMENT ON COLUMN lojas_Fornecedoras.ID_Loja IS 'Identificador único da loja fornecedora.';
COMMENT ON COLUMN lojas_Fornecedoras.Nome_Loja IS 'Nome da Loja';
COMMENT ON COLUMN lojas_Fornecedoras.Endereco IS 'Endereço da loja';
COMMENT ON COLUMN lojas_Fornecedoras.Telefone IS 'Telefone da loja';
COMMENT ON COLUMN lojas_Fornecedoras.Email IS 'Email da loja';
COMMENT ON COLUMN lojas_Fornecedoras.CNPJ IS 'CNPJ da loja';

CREATE TABLE pedido (
  ID_pedido          SERIAL NOT NULL, 
  ID_cliente         int4 NOT NULL, 
  data_pedido        date NOT NULL, 
  status_pedido      varchar(50) NOT NULL, 
  entregaID_entrega  int4 NOT NULL, 
  entregaID_entrega2 int4, 
  PRIMARY KEY (ID_pedido)
);
COMMENT ON TABLE pedido IS 'Pedido do cliente';
COMMENT ON COLUMN pedido.ID_pedido IS 'Identificador único do pedido';
COMMENT ON COLUMN pedido.ID_cliente IS 'Referência ao cliente final';
COMMENT ON COLUMN pedido.data_pedido IS 'Data do pedido';
COMMENT ON COLUMN pedido.status_pedido IS 'Status do pedido';

CREATE TABLE produto (
  ID_produto   SERIAL NOT NULL, 
  nome_produto varchar(45) NOT NULL, 
  descricao    varchar(100) NOT NULL, 
  categoria    varchar(30) NOT NULL, 
  preco_base   numeric(10, 2) NOT NULL, 
  fabricante   varchar(50) NOT NULL, 
  PRIMARY KEY (ID_produto)
);
COMMENT ON TABLE produto IS 'Produtos da loja';
COMMENT ON COLUMN produto.ID_produto IS 'Identificador único do produto.';
COMMENT ON COLUMN produto.nome_produto IS 'Nome do Produto';
COMMENT ON COLUMN produto.descricao IS 'Descrição do Produto';
COMMENT ON COLUMN produto.categoria IS 'Categoria do produto';
COMMENT ON COLUMN produto.preco_base IS 'Preço base do produto';
COMMENT ON COLUMN produto.fabricante IS 'Fabricante do produto';

CREATE TABLE suporte_cliente (
  id_suporte              BIGSERIAL NOT NULL, 
  cliente_finalID_cliente int4 NOT NULL, 
  data_solic              date NOT NULL, 
  tipo_problema           varchar(255) NOT NULL, 
  descricao_probl         varchar(255), 
  status_ticket           int2 NOT NULL CHECK (status_ticket IN (1, 2, 3, 4)), 
  data_resolucao          date NOT NULL, 
  PRIMARY KEY (id_suporte)
);
COMMENT ON TABLE suporte_cliente IS 'Tabela destinada a gerenciar os tickets/demandas de suporte dos clientes, permitindo rastrear as solicitações de suporte, status e resolução. Além de permitir entender a dor do cliente e evoluir como empresa em cima disso.';
COMMENT ON COLUMN suporte_cliente.id_suporte IS 'ID para cada ticket';
COMMENT ON COLUMN suporte_cliente.data_solic IS 'Data da solicitação feita pelo cliente';
COMMENT ON COLUMN suporte_cliente.tipo_problema IS 'Tipo/local do problema enfrentado pelo cliente';
COMMENT ON COLUMN suporte_cliente.descricao_probl IS 'Descrição do problema enfrentado pelo cliente';
COMMENT ON COLUMN suporte_cliente.status_ticket IS 'Status do ticket

Em aberto -> 1
Em andamento -> 2
Resolvido -> 3
Fechado -> 4';
COMMENT ON COLUMN suporte_cliente.data_resolucao IS 'Data da resolução do ticket';

ALTER TABLE catalogo_de_produtos ADD CONSTRAINT FKcatalogo_d838315 FOREIGN KEY (lojas_FornecedorID_Loja) REFERENCES lojas_Fornecedoras (ID_Loja);
ALTER TABLE estoque ADD CONSTRAINT FKestoque160270 FOREIGN KEY (lojas_FornecedorID_Loja) REFERENCES lojas_Fornecedoras (ID_Loja);
ALTER TABLE faturamento ADD CONSTRAINT FKfaturament264617 FOREIGN KEY (pedidoID_pedido) REFERENCES pedido (ID_pedido);
ALTER TABLE estoque ADD CONSTRAINT FKestoque320915 FOREIGN KEY (ID_produto) REFERENCES produto (ID_produto);
ALTER TABLE pedido ADD CONSTRAINT FKpedido944248 FOREIGN KEY (ID_cliente) REFERENCES cliente_final (ID_cliente);
ALTER TABLE pedido ADD CONSTRAINT FKpedido242359 FOREIGN KEY (entregaID_entrega2) REFERENCES entrega (ID_entrega);
ALTER TABLE devolucao ADD CONSTRAINT FKdevolucao956697 FOREIGN KEY (pedidoID_pedido) REFERENCES pedido (ID_pedido);
ALTER TABLE suporte_cliente ADD CONSTRAINT FKsuporte_cl789259 FOREIGN KEY (cliente_finalID_cliente) REFERENCES cliente_final (ID_cliente);
