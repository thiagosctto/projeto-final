package br.com.PixelMart.projeto.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Pagamentos")
public class Pagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nome_no_cartao", length = 100, nullable = false)
    private String nomeNoCartao;

    @Column(name = "numero_do_cartao", length = 16, nullable = false)
    private String numeroDoCartao;

    @Column(name = "data_validade", length = 5, nullable = false) // Formato MM/AA
    private String dataValidade;

    @Column(name = "cvv", length = 3, nullable = false)
    private String cvv;

    // Construtor padrão
    public Pagamento() {}

    // Construtor com parâmetros
    public Pagamento(String nomeNoCartao, String numeroDoCartao, String dataValidade, String cvv) {
        this.nomeNoCartao = nomeNoCartao;
        this.numeroDoCartao = numeroDoCartao;
        this.dataValidade = dataValidade;
        this.cvv = cvv;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeNoCartao() {
        return nomeNoCartao;
    }

    public void setNomeNoCartao(String nomeNoCartao) {
        this.nomeNoCartao = nomeNoCartao;
    }

    public String getNumeroDoCartao() {
        return numeroDoCartao;
    }

    public void setNumeroDoCartao(String numeroDoCartao) {
        this.numeroDoCartao = numeroDoCartao;
    }

    public String getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(String dataValidade) {
        this.dataValidade = dataValidade;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }
}
