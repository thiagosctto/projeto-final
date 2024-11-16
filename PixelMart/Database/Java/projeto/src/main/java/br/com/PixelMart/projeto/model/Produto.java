package br.com.PixelMart.projeto.model;
import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "produto")
public class Produto {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_produto")
    private Integer id;

    @Column(name = "nome_produto", length = 45, nullable = false)
    private String nomeProduto;

    @Column(name = "descricao", length = 100, nullable = false)
    private String descricao;

    @Column(name = "categoria", length = 30, nullable = false)
    private String categoria;

    @Column(name = "preco_base", precision = 10, scale = 2, nullable = false)
    private BigDecimal precoBase;

    @Column(name = "fabricante", length = 50, nullable = false)
    private String fabricante;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public BigDecimal getPrecoBase() {
		return precoBase;
	}

	public void setPrecoBase(BigDecimal precoBase) {
		this.precoBase = precoBase;
	}

	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

    
}
