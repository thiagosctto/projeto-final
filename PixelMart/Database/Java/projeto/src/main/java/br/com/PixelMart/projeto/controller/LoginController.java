package br.com.PixelMart.projeto.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.PixelMart.projeto.DAO.ILogins; // Certifique-se de que este é o repositório correto
import br.com.PixelMart.projeto.model.Logins;

@RestController
@CrossOrigin("*")
@RequestMapping("/auth")
public class LoginController {

    @Autowired
    private ILogins loginRepository;

    @PostMapping("/login")
    public ResponseEntity<Logins> login(@RequestBody Logins loginData) {
        Optional<Logins> login = loginRepository.findByUsuarioAndSenha(loginData.getUsuario(), loginData.getSenha());

        if (login.isPresent()) {
            return ResponseEntity.ok(login.get()); 
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build(); 
        }
    }
}
