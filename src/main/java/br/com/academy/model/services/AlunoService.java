package br.com.academy.model.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.academy.model.entities.Aluno;
import br.com.academy.repositories.AlunoRepository;

@Service
public class AlunoService {
	
	@Autowired
	AlunoRepository alunoRepository;
	
	public Aluno insert(Aluno aluno) {
		return alunoRepository.save(aluno);
	}

}
