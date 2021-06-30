package br.com.generation.gamefree.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.generation.gamefree.model.Categoria;

@Repository
public interface CategoriaRepository  extends JpaRepository<Categoria, Long>{
	
	@GetMapping
	public List <Categoria> findAllByNomeContainIgnoreCase(String nome);
	@GetMapping
	public List <Categoria> findAllByGeneroContainIgnoreCase(String genero);
}
