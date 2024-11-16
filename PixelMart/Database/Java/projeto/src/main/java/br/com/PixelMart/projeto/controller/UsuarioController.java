package br.com.PixelMart.projeto.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.PixelMart.projeto.DAO.ILogins;
import br.com.PixelMart.projeto.DAO.IUsuario;
import br.com.PixelMart.projeto.model.Logins;
import br.com.PixelMart.projeto.model.Usuario;

@RestController
@CrossOrigin("*")
@RequestMapping("/usuarios")
public class UsuarioController{
	
	// para não ter que usar implements e usar todos o metodos do crud repositorio 
	@Autowired
	private IUsuario dao;
	
	@Autowired
    private ILogins loginDao;
	
	
	@GetMapping 
	public List<Usuario> listaUsuario (){
		return (List<Usuario>) dao.findAll();
	}
	
	@PostMapping
	public Usuario criarUsuario (@RequestBody Usuario usuario) {
		Usuario usuarionovo = dao.save(usuario);
		Logins novoLogin = new Logins();
        novoLogin.setUsuario(usuarionovo.getEmail()); 
        novoLogin.setSenha(usuarionovo.getSenha()); 
        loginDao.save(novoLogin);
		return usuarionovo;
	}
	
	
	@PutMapping
	public Usuario editarUsuario (@RequestBody Usuario usuario) {
		Usuario usuarionovo = dao.save(usuario);
		return usuarionovo;
	}
	
	
	@DeleteMapping("/{id}")
	public Optional<Usuario> deletarUsuario (@PathVariable Integer id) { 
		Optional<Usuario> usuario = dao.findById(id);
		if (id != 0) {
			dao.deleteById(id);
		}
		return usuario;
	}
	
}
