package com.generation.farmacia.controller;

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

import com.generation.farmacia.model.Produto;
import com.generation.farmacia.repository.ProdutoRepository;

@RestController
@RequestMapping("/Produtos")
@CrossOrigin("*")
public class ProdutoController {

		@Autowired
		private ProdutoRepository produtoRepository;
		
		
		@GetMapping
		public ResponseEntity<List<Produto>> GetAll() {
			return ResponseEntity.ok(produtoRepository.findAll());
		}
		
		@GetMapping("/{id}")
		public ResponseEntity<Produto> GetById(@PathVariable Long id) {
			return produtoRepository.findById(id)
			.map(resposta -> ResponseEntity.ok(resposta))
			.orElse(ResponseEntity.notFound().build());
		}
		
		@GetMapping("/nome/{nome}")
		public ResponseEntity<List<Produto>> GetByNome(@PathVariable String nomeProduto) {
			return ResponseEntity.ok(produtoRepository.findAllByNomeContainingIgnoreCase(nomeProduto));
		}
		
		@PostMapping
		public ResponseEntity<Produto> post (@RequestBody Produto produto) {
			return ResponseEntity.status(HttpStatus.CREATED).body(produtoRepository.save(produto));
			
		}
		
		@PutMapping
		public ResponseEntity<Produto> putProduto (@Valid @RequestBody Produto produto) {
			return produtoRepository.findById(produto.getId())
					.map(resposta -> ResponseEntity.status(HttpStatus.OK)
					.body(produtoRepository.save(produto)))
					.orElse(ResponseEntity.notFound().build());
		}
		
		@DeleteMapping("/{id}")
		public ResponseEntity<Object> deleteProduto (@PathVariable Long id) {
			return produtoRepository.findById(id).map(resposta -> {
				produtoRepository.deleteById(id);
				return ResponseEntity.ok().build();
			}).orElse(ResponseEntity.notFound().build());
			
		}
	}