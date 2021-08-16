package com.Game.LojadeGame.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name="tb_produto")
public class Produto {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	@Size(min=2,max=20)
	private String nome;
	
	@NotBlank
	@Size(min=2,max=20)
	private Long preco;
	
	
	@NotBlank
	@Size(min=2,max=20)
	private String Qualidade;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JsonIgnoreProperties({ "listaDeProdutos" })
	private Categoria categoria;
	
	
	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

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

	public Long getPreco() {
		return preco;
	}

	public void setPreco(Long preco) {
		this.preco = preco;
	}

	public String getQualidade() {
		return Qualidade;
	}

	public void setQualidade(String qualidade) {
		Qualidade = qualidade;
	}

}
