package br.com.PixelMart.projeto.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "catalogo_de_produtos")

public class CatalogoProdutos {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Catalogo")
    private Integer id;

    @Column(name = "Preco", precision = 10, scale = 2, nullable = false)
    private BigDecimal preco;

    @Column(name = "data_inclusao", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dataInclusao;

    @Column(name = "lojas_FornecedorID_Loja", nullable = false)
    private String lojaFornecedor;

    @ManyToOne
    @JoinColumn(name = "produtoID_produto", nullable = false)
    private Produto produto;  // Alteração: usar a classe Produto em vez de String

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public Date getDataInclusao() {
        return dataInclusao;
    }

    public void setDataInclusao(Date dataInclusao) {
        this.dataInclusao = dataInclusao;
    }

    public String getLojaFornecedor() {
        return lojaFornecedor;
    }

    public void setLojaFornecedor(String lojaFornecedor) {
        this.lojaFornecedor = lojaFornecedor;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    
}
