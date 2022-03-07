package com.generation.lojadegames.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_produto")

public class Produto {
	
	 public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public String getDescricaoProduto() {
		return descricaoProduto;
	}

	public void setDescricaoProduto(String descricaoProduto) {
		this.descricaoProduto = descricaoProduto;
	}

	public String getPrecoProduto() {
		return precoProduto;
	}

	public void setPrecoProduto(String precoProduto) {
		this.precoProduto = precoProduto;
	}
	

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	@ManyToOne
	@JsonIgnoreProperties("postagem")
	private Usuario usuario;

	@ManyToOne
     @JsonIgnoreProperties("categoria")
     private Categoria categoria;

	@Id
	@GeneratedValue (strategy =GenerationType.IDENTITY)
	private long id;
	
	@NotBlank(message = "O preenchimento é obrigatório e não pode ser deixado em branco")
	@Size(min = 1, max = 100)
	private String nomeProduto;
	
	@NotBlank(message = "O preenchimento é obrigatório e não pode ser deixado em branco")
	@Size(min = 5, max = 500)
	private String descricaoProduto;
	
	@NotBlank
	private String precoProduto;

	}

