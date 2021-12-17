package br.com.academy.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.academy.model.entities.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long>{

}
