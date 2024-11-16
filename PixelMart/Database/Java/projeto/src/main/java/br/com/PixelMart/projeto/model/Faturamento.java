package br.com.PixelMart.projeto.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "faturamento")
public class Faturamento {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "ID_faturamento")
	    private Integer id;

	    @Column(name = "valor_total", precision = 10, scale = 2, nullable = false)
	    private BigDecimal valorTotal;

	    @Column(name = "data_faturamento", nullable = false)
	    @Temporal(TemporalType.DATE)
	    private Date dataFaturamento;

	    @ManyToOne
	    @JoinColumn(name = "pedidoID_pedido", nullable = false)
	    private Pedido pedido;

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public BigDecimal getValorTotal() {
			return valorTotal;
		}

		public void setValorTotal(BigDecimal valorTotal) {
			this.valorTotal = valorTotal;
		}

		public Date getDataFaturamento() {
			return dataFaturamento;
		}

		public void setDataFaturamento(Date dataFaturamento) {
			this.dataFaturamento = dataFaturamento;
		}

		public Pedido getPedido() {
			return pedido;
		}

		public void setPedido(Pedido pedido) {
			this.pedido = pedido;
		}

		
}
