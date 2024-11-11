package br.com.PixelMart.projeto.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "entrega")
public class Entrega {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_entrega")
    private Integer id;

    @Column(name = "data_envio", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dataEnvio;

    @Column(name = "data_entrega", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dataEntrega;

    @Column(name = "status_entrega", length = 50, nullable = false)
    private String statusEntrega;

    @Column(name = "metodo_entrega", length = 50, nullable = false)
    private String metodoEntrega;

    @ManyToOne
    @JoinColumn(name = "pedidoID_pedido", nullable = false)
    private Pedido pedido;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDataEnvio() {
		return dataEnvio;
	}

	public void setDataEnvio(Date dataEnvio) {
		this.dataEnvio = dataEnvio;
	}

	public Date getDataEntrega() {
		return dataEntrega;
	}

	public void setDataEntrega(Date dataEntrega) {
		this.dataEntrega = dataEntrega;
	}

	public String getStatusEntrega() {
		return statusEntrega;
	}

	public void setStatusEntrega(String statusEntrega) {
		this.statusEntrega = statusEntrega;
	}

	public String getMetodoEntrega() {
		return metodoEntrega;
	}

	public void setMetodoEntrega(String metodoEntrega) {
		this.metodoEntrega = metodoEntrega;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

}
