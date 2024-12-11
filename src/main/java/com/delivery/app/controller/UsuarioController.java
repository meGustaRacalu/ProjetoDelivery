package com.delivery.app.controller;

import java.util.List;

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

import com.delivery.app.model.Usuario;
import com.delivery.app.service.UsuarioService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;

	@GetMapping("/{id}")
	public ResponseEntity<Usuario> getUsuarioById(@PathVariable Long id) {
		return usuarioService.findUsuarioById(id).map(usuario -> ResponseEntity.ok(usuario))
				.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}

	@GetMapping
	public ResponseEntity<List<Usuario>> getAllUsuarios() {
		return ResponseEntity.ok(usuarioService.findAllUsuarios());
	}

	@PostMapping("/cadastrar")
	public ResponseEntity<Usuario> createUsuario(@Valid @RequestBody Usuario usuario) {
		return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.saveUsuario(usuario));
	}

	@PutMapping("/atualizar")
	public ResponseEntity<Usuario> updateUsuario(@Valid @RequestBody Usuario usuario) {
		return usuarioService.findUsuarioById(usuario.getId())
				.map(resposta -> ResponseEntity.ok(usuarioService.saveUsuario(usuario)))
				.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteUsuario(@PathVariable Long id) {
		if (usuarioService.findUsuarioById(id).isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		usuarioService.deleteUsuario(id);
		return ResponseEntity.noContent().build();
	}
}
