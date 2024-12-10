package com.delivery.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.delivery.app.model.Produtos;

public interface ProdutosRepository extends JpaRepository <Produtos, Long> {

	List<Produtos> findAllByNomeContainingIgnoreCase(String nome);
	
	List<Produtos> findAllByCategoriaContainingIgnoreCase(String Categoria);
	
	}
	
