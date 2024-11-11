package br.com.PixelMart.projeto.model;
import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "pedido")
public class Pedido {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_pedido")
    private Integer id;

    @Column(name = "data_pedido", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dataPedido;

    @Column(name = "status_pedido", length = 50, nullable = false)
    private String statusPedido;

    @ManyToOne
    @JoinColumn(name = "ID_cliente", nullable = false)
    private ClienteFinal cliente;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDataPedido() {
		return dataPedido;
	}

	public void setDataPedido(Date dataPedido) {
		this.dataPedido = dataPedido;
	}

	public String getStatusPedido() {
		return statusPedido;
	}

	public void setStatusPedido(String statusPedido) {
		this.statusPedido = statusPedido;
	}

	public ClienteFinal getCliente() {
		return cliente;
	}

	public void setCliente(ClienteFinal cliente) {
		this.cliente = cliente;
	}

    
}
