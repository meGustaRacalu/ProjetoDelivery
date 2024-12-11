package com.delivery.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.delivery.app.model.Produtos;
import com.delivery.app.repository.ProdutosRepository;
import com.delivery.app.service.ProdutosService;

import jakarta.validation.Valid;

@RequestMapping("/produtos")
@RestController
public class ProdutosController {

	@Autowired
	private ProdutosRepository produtoRepository;

	@Autowired
	private ProdutosService produtosService;

	@GetMapping
	public ResponseEntity<List<Produtos>> getAll() {
		return ResponseEntity.ok(produtoRepository.findAll());

	}

	@GetMapping("/nome/{nome}")
	public ResponseEntity<List<Produtos>> getByNome(@PathVariable String nome) {
		return ResponseEntity.ok(produtoRepository.findAllByNomeContainingIgnoreCase(nome));
	}

	@GetMapping("/saudaveis")
	public List<Produtos> getProdutosSaudaveis() {
		return produtosService.ProdutosSaudaveis();
	}

	@PostMapping("/cadastrar")
	public ResponseEntity<Produtos> post(@Valid @RequestBody Produtos produto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(produtoRepository.save(produto));
	}

	@PutMapping("/atualizar")
	public ResponseEntity<Produtos> put(@Valid @RequestBody Produtos produto) {
		return produtoRepository.findById(produto.getId())
				.map(resposta -> ResponseEntity.status(HttpStatus.OK).body(produtoRepository.save(produto)))
				.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		Optional<Produtos> produto = produtoRepository.findById(id);

		if (produto.isEmpty())
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);

		produtoRepository.deleteById(id);
	}

}
