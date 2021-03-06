package br.com.academy.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.academy.model.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	
	@Query(value = "SELECT u FROM Usuario u WHERE u.email = :email")
	public Usuario findByEmail(String email);

	
	@Query(value = "SELECT u FROM Usuario u "
			+ "WHERE u.email = :email "
			+ "AND u.codigoSenha = :codigoSenha")
	public Usuario findByLogin(String email, String codigoSenha);

}
