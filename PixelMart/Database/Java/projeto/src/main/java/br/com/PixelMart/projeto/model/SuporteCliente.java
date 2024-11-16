package br.com.PixelMart.projeto.model;
import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "suporte_cliente")
public class SuporteCliente {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_suporte")
    private Long id;

    @Column(name = "data_solic", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dataSolicitacao;

    @Column(name = "tipo_problema", length = 255, nullable = false)
    private String tipoProblema;

    @Column(name = "descricao_probl", length = 255)
    private String descricaoProblema;

    @Column(name = "status_ticket", nullable = false)
    private Short statusTicket;

    @Column(name = "data_resolucao", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dataResolucao;

    @ManyToOne
    @JoinColumn(name = "cliente_finalID_cliente", nullable = false)
    private ClienteFinal cliente;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDataSolicitacao() {
		return dataSolicitacao;
	}

	public void setDataSolicitacao(Date dataSolicitacao) {
		this.dataSolicitacao = dataSolicitacao;
	}

	public String getTipoProblema() {
		return tipoProblema;
	}

	public void setTipoProblema(String tipoProblema) {
		this.tipoProblema = tipoProblema;
	}

	public String getDescricaoProblema() {
		return descricaoProblema;
	}

	public void setDescricaoProblema(String descricaoProblema) {
		this.descricaoProblema = descricaoProblema;
	}

	public Short getStatusTicket() {
		return statusTicket;
	}

	public void setStatusTicket(Short statusTicket) {
		this.statusTicket = statusTicket;
	}

	public Date getDataResolucao() {
		return dataResolucao;
	}

	public void setDataResolucao(Date dataResolucao) {
		this.dataResolucao = dataResolucao;
	}

	public ClienteFinal getCliente() {
		return cliente;
	}

	public void setCliente(ClienteFinal cliente) {
		this.cliente = cliente;
	}

    
}
