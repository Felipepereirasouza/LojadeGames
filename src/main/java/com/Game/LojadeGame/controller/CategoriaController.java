package com.Game.LojadeGame.controller;

import java.util.List;

import javax.validation.Valid;

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

import com.Game.LojadeGame.GameRepositorio.CategoriaRepositorio;
import com.Game.LojadeGame.model.Categoria;

@RestController
@RequestMapping("/categoria")
@CrossOrigin("*")
public class CategoriaController {

	@Autowired
	private CategoriaRepositorio repositorio;

	@GetMapping
	public ResponseEntity<List<Categoria>> getAll() {
		return ResponseEntity.ok(repositorio.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Categoria> getById(@Valid @PathVariable Long id) {

		return repositorio.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}

	@GetMapping("/categoria/{categoria}")
	public ResponseEntity<List<Categoria>> GetbyCategoria(@Valid @PathVariable String categoria)

	{
		return ResponseEntity.ok(repositorio.findAllByCategoriaContainingIgnoreCase(categoria));

	}

	@GetMapping("/quantidades/{quantidades}")
	public ResponseEntity<List<Categoria>> Getbyquantidades(@Valid @PathVariable String quantidades)

	{
		return ResponseEntity.ok(repositorio.findAllByQuantidadesContainingIgnoreCase(quantidades));

	}

	
	@GetMapping("/controle/{controle}")
	public ResponseEntity<List<Categoria>> GetByControle(@PathVariable String controle){
		
		return ResponseEntity.ok(repositorio.findAllByTipoControleContainingIgnoreCase(controle));
		
	}
	
	@PostMapping("/salvar")
	
	public ResponseEntity<Categoria> Salvarcategoria(@RequestBody Categoria novacategoria)	{
		
		return ResponseEntity.ok(repositorio.save(novacategoria));
		
	}
	
	@PutMapping("/alterar")
	
	public ResponseEntity<Categoria> Alterarcategoria(@RequestBody Categoria alterar){
		return ResponseEntity.ok(repositorio.save(alterar));
	}
	
	
	@DeleteMapping ("/id/{id}")
	
	public void Deletarid (@Valid @PathVariable Long id) {
		
		 repositorio.deleteById(id);
		ResponseEntity.ok(200);
		
	}
	
}
