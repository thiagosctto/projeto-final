package br.com.PixelMart.projeto.model;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "logins")
public class Logins {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "usuario", length = 100, nullable = false, unique = true)
    private String usuario;

    @Column(name = "senha", length = 100, nullable = false)
    private String senha;

    @Column(name = "ultimo_login")
    private LocalDateTime ultimoLogin;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public LocalDateTime getUltimoLogin() {
		return ultimoLogin;
	}

	public void setUltimoLogin(LocalDateTime ultimoLogin) {
		this.ultimoLogin = ultimoLogin;
	}
}
