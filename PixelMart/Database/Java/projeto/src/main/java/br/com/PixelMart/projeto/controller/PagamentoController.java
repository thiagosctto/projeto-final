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

import br.com.PixelMart.projeto.DAO.IPagamento;
import br.com.PixelMart.projeto.model.Pagamento;

@RestController
@CrossOrigin("*")
@RequestMapping("/pagamentos")
public class PagamentoController {

    @Autowired
    private IPagamento pagamentoDao;

    // Listar todos os pagamentos
    @GetMapping
    public List<Pagamento> listarPagamentos() {
        return (List<Pagamento>) pagamentoDao.findAll();
    }

    // Buscar um pagamento pelo ID
    @GetMapping("/{id}")
    public Optional<Pagamento> buscarPagamento(@PathVariable Long id) {
        return pagamentoDao.findById(id);
    }

    // Criar um novo pagamento
    @PostMapping
    public Pagamento criarPagamento(@RequestBody Pagamento pagamento) {
        return pagamentoDao.save(pagamento);
    }

    // Atualizar um pagamento existente
    @PutMapping
    public Pagamento editarPagamento(@RequestBody Pagamento pagamento) {
        return pagamentoDao.save(pagamento);
    }

    // Deletar um pagamento pelo ID
    @DeleteMapping("/{id}")
    public Optional<Pagamento> deletarPagamento(@PathVariable Long id) {
        Optional<Pagamento> pagamento = pagamentoDao.findById(id);
        if (pagamento.isPresent()) {
            pagamentoDao.deleteById(id);
        }
        return pagamento;
    }
}
