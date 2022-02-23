package com.generation.lojadegames.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generation.lojadegames.model.Categoria;
import com.generation.lojadegames.repository.CategoriaRepository;

@RestController
@RequestMapping("/Categorias")
@CrossOrigin("*")
public class CategoriaController {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	
	@GetMapping
	public ResponseEntity<List<Categoria>> GetAll() {
		return ResponseEntity.ok(categoriaRepository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Categoria> GetById(@PathVariable Long id) {
		return categoriaRepository.findById(id)
		.map(resposta -> ResponseEntity.ok(resposta))
		.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/nome/{nome}")
	public ResponseEntity<List<Categoria>> GetByNome(@PathVariable String nome) {
		return ResponseEntity.ok(categoriaRepository.findAllByNomeContainingIgnoreCase(nome));
	}
	
	@PostMapping
	public ResponseEntity<Categoria> post (@RequestBody Categoria categoria) {
		return ResponseEntity.status(HttpStatus.CREATED).body(categoriaRepository.save(categoria));
		
	}
	
	@PutMapping
	public ResponseEntity<Categoria> putCategoria (@Valid @RequestBody Categoria categoria) {
		return categoriaRepository.findById(categoria.getId())
				.map(resposta -> ResponseEntity.status(HttpStatus.OK)
				.body(categoriaRepository.save(categoria)))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteCategoria (@PathVariable Long id) {
		return categoriaRepository.findById(id).map(resposta -> {
			categoriaRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}).orElse(ResponseEntity.notFound().build());
		
	}
}