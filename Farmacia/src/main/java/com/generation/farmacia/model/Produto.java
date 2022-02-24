package com.generation.farmacia.model;

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

	@ManyToOne
     @JsonIgnoreProperties("categoria")
     private Categoria categoria;

	@Id
	@GeneratedValue (strategy =GenerationType.IDENTITY)
	private long id;
	
	@NotBlank(message = "O preenchimento é obrigatório e não pode ser deixado em branco")
	@Size(min = 1, max = 300)
	private String descricao;
	
	@NotBlank(message = "O preenchimento é obrigatório e não pode ser deixado em branco")
	private String laboratorio;
	
	@NotBlank(message = "O preenchimento é obrigatório e não pode ser deixado em branco")
	private String nome;
	
	@NotBlank(message = "O preenchimento é obrigatório e não pode ser deixado em branco")
	private String quantidade;

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

	public String getDescricaoProduto() {
		return descricao;
	}

	public void setDescricaoProduto(String descricaoProduto) {
		this.descricao = descricaoProduto;
	}

	public String getLaboratorio() {
		return laboratorio;
	}

	public void setLaboratorio(String laboratorio) {
		this.laboratorio = laboratorio;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(String quantidade) {
		this.quantidade = quantidade;
	}
	

	}
