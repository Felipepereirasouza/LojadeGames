package com.Game.LojadeGame.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table (name="tb_categoria")
public class Categoria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	@Size(min=2,max=20)
	private String categoria;
	
	@NotBlank
	@Size(min=2,max=20)
	private String quantidades;
	
	
	
	
	@NotBlank
	@Size(min=2,max=20)
	private String tipoControle;

	
	@OneToMany(mappedBy = "categoria", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties({ "categoria" })
	private List<Produto> listaDeProdutos = new ArrayList<>();
	
	public List<Produto> getListaDeProdutos() {
		return listaDeProdutos;
	}

	public void setListaDeProdutos(List<Produto> listaDeProdutos) {
		this.listaDeProdutos = listaDeProdutos;
	}

	public String getTipoControle() {
		return tipoControle;
	}

	public void setTipoControle(String tipoControle) {
		this.tipoControle = tipoControle;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getQuantidades() {
		return quantidades;
	}

	public void setQuantidades(String quantidades) {
		this.quantidades = quantidades;
	}


}
