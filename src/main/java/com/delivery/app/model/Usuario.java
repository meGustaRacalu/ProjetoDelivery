package com.delivery.app.model;

	import jakarta.persistence.Entity;
	import jakarta.persistence.GeneratedValue;
	import jakarta.persistence.GenerationType;
	import jakarta.persistence.Id;
	import jakarta.persistence.Table;
	import jakarta.validation.constraints.Email;
	import jakarta.validation.constraints.NotNull;

	@Entity
	@Table(name = "tb_usuarios")
	public class Usuario {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @NotNull(message = "Coloque um nome do usuário valido")
	    private String nome;

	    @NotNull @NotNull(message = "Coloque um E-mail valido")
	    @Email
	    private String email;

	    @NotNull(message = "Coloque uma senha valida")
	    private String senha;

	    private String foto;
	    
	    public Long getId() {
	        return id;
	    }

	    public void setId(Long id) {
	        this.id = id;
	    }

	    public String getNomeUsuario() {
	        return nomeUsuario;
	    }

	    public void setNomeUsuario(String nome) {
	        this.nome = nomeUsuario;
	    }

	    public String getEmail() {
	        return email;
	    }

	    public void setEmail(String email) {
	        this.email = email;
	    }

	    public String getSenha() {
	        return senha;
	    }

	    public void setSenha(String senha) {
	        this.senha = senha;
	    }
	    public String getFoto() {
	        return foto;
	    }

	    public void setFoto(String foto) {
	        this.foto = foto;
	    }
	}