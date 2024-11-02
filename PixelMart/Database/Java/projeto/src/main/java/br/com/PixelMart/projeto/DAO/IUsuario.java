package br.com.PixelMart.projeto.DAO;

import org.springframework.data.repository.CrudRepository;

import br.com.PixelMart.projeto.model.Usuario;

public interface IUsuario extends CrudRepository<Usuario, Integer>{
	
}
