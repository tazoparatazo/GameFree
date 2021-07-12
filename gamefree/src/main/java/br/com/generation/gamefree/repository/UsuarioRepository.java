package br.com.generation.gamefree.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.generation.gamefree.model.Usuario;



public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	
	public Optional<Usuario> findByUsuario(String usuario);

	public Usuario findByNome(String nome);

	public List<Usuario> findAllByNomeContainingIgnoreCase(String nome);

}