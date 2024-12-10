package com.delivery.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.delivery.app.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	public List<Usuario> findAllByNomeContainingIgnoreCase(String usuario);
}


