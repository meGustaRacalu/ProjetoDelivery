package com.delivery.app.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.delivery.app.model.Categoria;
import com.delivery.app.model.Produtos;
import com.delivery.app.repository.CategoriaRepository;
import com.delivery.app.repository.ProdutosRepository;

@Service
public class ProdutosService {

	@Autowired
	private ProdutosRepository produtosRepository;

	@Autowired
	private CategoriaRepository categoriaRepository;

	public List<Produtos> ProdutosSaudaveis() {
		Categoria categoriaSaudavel = categoriaRepository.findByDescricao("Produtos saudaveis");

		if (categoriaSaudavel == null) {
			return List.of();
		}

		List<Produtos> produtosSaudaveis = produtosRepository.findAll().stream()
				.filter(produto -> produto.getCategoria() != null
						&& produto.getCategoria().getId().equals(categoriaSaudavel.getId()))
				.collect(Collectors.toList());

		return produtosSaudaveis;
	}
}
