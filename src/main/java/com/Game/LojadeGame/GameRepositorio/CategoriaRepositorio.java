package com.Game.LojadeGame.GameRepositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.Game.LojadeGame.model.Categoria;

@Repository
public interface CategoriaRepositorio extends JpaRepository<Categoria, Long> {

	
  List<Categoria> findAllByCategoriaContainingIgnoreCase (String categoria);
	
 
  List<Categoria> findAllByTipoControleContainingIgnoreCase (String tipoControle);
	

  List<Categoria> findAllByQuantidadesContainingIgnoreCase (String Quantidades);

 
 
}
