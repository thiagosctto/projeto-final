package br.com.PixelMart.projeto.DAO;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import br.com.PixelMart.projeto.model.Logins;

public interface ILogins extends JpaRepository<Logins, Integer> {
    Optional<Logins> findByUsuarioAndSenha(String usuario, String senha);
}

