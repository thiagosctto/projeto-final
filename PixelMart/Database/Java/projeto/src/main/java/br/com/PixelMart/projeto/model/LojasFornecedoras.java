package br.com.PixelMart.projeto.model;
import jakarta.persistence.*;

@Entity
@Table(name = "lojas_Fornecedoras")
public class LojasFornecedoras {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "ID_Loja")
	    private Integer id;

	    @Column(name = "Nome_Loja", length = 80, nullable = false)
	    private String nomeLoja;

	    @Column(name = "Endereco", length = 80, nullable = false)
	    private String endereco;

	    @Column(name = "Telefone", length = 15, nullable = false)
	    private String telefone;

	    @Column(name = "Email", length = 50, nullable = false, unique = true)
	    private String email;

	    @Column(name = "CNPJ", length = 20, nullable = false, unique = true)
	    private String cnpj;

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public String getNomeLoja() {
			return nomeLoja;
		}

		public void setNomeLoja(String nomeLoja) {
			this.nomeLoja = nomeLoja;
		}

		public String getEndereco() {
			return endereco;
		}

		public void setEndereco(String endereco) {
			this.endereco = endereco;
		}

		public String getTelefone() {
			return telefone;
		}

		public void setTelefone(String telefone) {
			this.telefone = telefone;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getCnpj() {
			return cnpj;
		}

		public void setCnpj(String cnpj) {
			this.cnpj = cnpj;
		}
}
