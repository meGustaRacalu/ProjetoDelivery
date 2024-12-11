package com.delivery.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.delivery.app.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

    List<Categoria> findAllByDescricaoContainingIgnoreCase(String descricao);

    Categoria findByDescricao(String descricao);  
}
