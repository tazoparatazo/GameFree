package br.com.generation.gamefree.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.generation.gamefree.model.Categoria;
import br.com.generation.gamefree.repository.CategoriaRepository;


@RestController
@RequestMapping("/categoria")
public class CategoriaController {
	
	@Autowired
	private  CategoriaRepository categoriaRepository;
	
	@GetMapping
	public ResponseEntity<List<Categoria>> getAll (){
		return ResponseEntity.ok(categoriaRepository.findAll());
	}

	
	@GetMapping("idifelse/{id}")
	public ResponseEntity<Categoria> getByIdIfElse(@PathVariable long id) {

		Optional<Categoria> categoria = categoriaRepository.findById(id);
		if (categoria.isPresent()) {
			return ResponseEntity.ok(categoria.get());
		}
		return ResponseEntity.notFound().build();
	}
	
	
	@GetMapping("/genero/{genero}")
	public ResponseEntity<List<Categoria>> getByGenero(@PathVariable String genero){
		return ResponseEntity.ok(categoriaRepository.findAllByGeneroContainIgnoreCase(genero));
}
	
	
	@PostMapping
	public ResponseEntity<Categoria> postCategoria (@RequestBody Categoria categoria){
		return ResponseEntity.status(HttpStatus.CREATED).body(categoriaRepository.save(categoria));
	}
	
	@PutMapping
	public ResponseEntity<Categoria> putCategoria (@RequestBody Categoria categoria){
		return ResponseEntity.status(HttpStatus.OK).body(categoriaRepository.save(categoria));
	}
	
	@DeleteMapping("/{id}")
	public void deleteCategoria(@PathVariable long id) {
		categoriaRepository.deleteById(id);
	}	
	
	
	
	
	
	
	
	
	
	
	
}