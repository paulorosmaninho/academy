package br.com.academy.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.academy.model.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
