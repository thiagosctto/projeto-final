package br.com.PixelMart.projeto.model;

import jakarta.persistence.*;

@Entity
@Table(name = "estoque")
public class Estoque {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_estoque")
    private Integer id;

    @Column(name = "qtd_disponivel")
    private Integer quantidadeDisponivel;

    @ManyToOne
    @JoinColumn(name = "ID_produto", nullable = false)
    private Produto produto;

    @ManyToOne
    @JoinColumn(name = "lojas_FornecedorID_Loja", nullable = false)
    private LojasFornecedoras lojaFornecedor;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getQuantidadeDisponivel() {
		return quantidadeDisponivel;
	}

	public void setQuantidadeDisponivel(Integer quantidadeDisponivel) {
		this.quantidadeDisponivel = quantidadeDisponivel;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public LojasFornecedoras getLojaFornecedor() {
		return lojaFornecedor;
	}

	public void setLojaFornecedor(LojasFornecedoras lojaFornecedor) {
		this.lojaFornecedor = lojaFornecedor;
	}

}
