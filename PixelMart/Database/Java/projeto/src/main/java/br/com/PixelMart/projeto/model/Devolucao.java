package br.com.PixelMart.projeto.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "devolucao")
public class Devolucao {

	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "ID_devolucao")
	    private Integer id;

	    @Column(name = "data_devolucao", nullable = false)
	    @Temporal(TemporalType.DATE)
	    private Date dataDevolucao;

	    @Column(name = "motivo_devol", length = 255)
	    private String motivoDevol;

	    @Column(name = "quant_devol", nullable = false)
	    private Integer quantDevol;

	    @ManyToOne
	    @JoinColumn(name = "pedidoID_pedido", nullable = false)
	    private Pedido pedido;

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public Date getDataDevolucao() {
			return dataDevolucao;
		}

		public void setDataDevolucao(Date dataDevolucao) {
			this.dataDevolucao = dataDevolucao;
		}

		public String getMotivoDevol() {
			return motivoDevol;
		}

		public void setMotivoDevol(String motivoDevol) {
			this.motivoDevol = motivoDevol;
		}

		public Integer getQuantDevol() {
			return quantDevol;
		}

		public void setQuantDevol(Integer quantDevol) {
			this.quantDevol = quantDevol;
		}

		public Pedido getPedido() {
			return pedido;
		}

		public void setPedido(Pedido pedido) {
			this.pedido = pedido;
		}

}
