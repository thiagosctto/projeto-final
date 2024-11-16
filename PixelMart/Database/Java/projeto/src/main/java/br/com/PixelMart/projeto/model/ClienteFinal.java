package br.com.PixelMart.projeto.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "cliente_final")
public class ClienteFinal {
		
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_cliente")
    private Integer id;

    @Column(name = "nome_cliente", length = 50, nullable = false)
    private String nomeCliente;

    @Column(name = "endereco", length = 120, nullable = false)
    private String endereco;

    @Column(name = "telefone", length = 15, nullable = false)
    private String telefone;

    @Column(name = "email", length = 120, nullable = false, unique = true)
    private String email;

    @Column(name = "CPF", length = 20, nullable = false, unique = true)
    private String cpf;

    @Column(name = "data_nasc", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dataNascimento;

    @Column(name = "cidade_cliente", length = 200, nullable = false)
    private String cidadeCliente;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getCidadeCliente() {
		return cidadeCliente;
	}

	public void setCidadeCliente(String cidadeCliente) {
		this.cidadeCliente = cidadeCliente;
	}
    
}
