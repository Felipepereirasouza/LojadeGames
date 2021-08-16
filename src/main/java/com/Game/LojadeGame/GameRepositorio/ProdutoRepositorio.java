package com.Game.LojadeGame.GameRepositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Game.LojadeGame.model.Produto;

@Repository
public interface ProdutoRepositorio extends JpaRepository<Produto, Long>  {
	
	
public List<Produto> findAllByNomeContainingIgnoreCase(String nome);

	
	

}
