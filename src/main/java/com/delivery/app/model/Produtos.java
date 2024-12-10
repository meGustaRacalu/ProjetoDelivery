package com.delivery.app.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


@Entity
@Table( name = "tb_produtos")

public class Produtos {



@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
	
@NotNull
@Size(max = 255)
private String nome;

	private float preco;
	private String categoria;
	private float entrega;
	
	
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public float getPreco() {
		return preco;
	}
	public void setPreco(float preco) {
		this.preco = preco;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public float getEntrega() {
		return entrega;
	}
	public void setEntrega(float entrega) {
		this.entrega = entrega;
	}
	 

	
}
