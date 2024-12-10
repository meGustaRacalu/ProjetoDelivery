package com.delivery.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.delivery.app.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
