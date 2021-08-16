package com.Game.LojadeGame.controller;

import java.util.List;
//import java.util.Optional;

import javax.validation.Valid;

//import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
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

import com.Game.LojadeGame.GameRepositorio.ProdutoRepositorio;
import com.Game.LojadeGame.model.Produto;



@RestController
@CrossOrigin("*")
@RequestMapping("/produto")
public class ProdutoController {

	
	@Autowired
	private ProdutoRepositorio produtoRepositorio;
	
	
	@GetMapping("/todos/{todos}")
	public ResponseEntity<List<Produto>> findAllProduto (){
		
		return ResponseEntity.ok(produtoRepositorio.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Produto>getById (@Valid @PathVariable Long id ) {
		
		return produtoRepositorio.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
		
		
	}
	
	@GetMapping("/titulo")
	
	public ResponseEntity<List<Produto>> findByDescricaoTitulo(@Valid @PathVariable String nome){
		
		return ResponseEntity.ok(produtoRepositorio.findAllByNomeContainingIgnoreCase(nome));
	}
	
	
	@PostMapping("/Salvar")
	
	public ResponseEntity<Object> salvarProduto (@Valid @RequestBody Produto postagemNova  ) {
		
		  return ResponseEntity.ok(produtoRepositorio.save(postagemNova));
	}
	
	
	@PutMapping("/alterar")
	
	public ResponseEntity<Object> Alterar (@Valid @RequestBody Produto Alteracao  ) {
		
		  return ResponseEntity.ok(produtoRepositorio.save(Alteracao));
	
	}
	
	
	@DeleteMapping ("/deletar/{id}")
	
	public void Alterar (@Valid @PathVariable Long id ) {
		
		produtoRepositorio.deleteById(id); 
		  
	
}
	
	
}
