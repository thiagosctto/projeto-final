package br.com.PixelMart.projeto.DAO;

import org.springframework.data.repository.CrudRepository;

import br.com.PixelMart.projeto.model.Pagamento;

public interface IPagamento extends CrudRepository<Pagamento, Long> {

}
