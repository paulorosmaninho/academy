package br.com.academy.model.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.academy.model.entities.Aluno;
import br.com.academy.model.entities.Usuario;
import br.com.academy.repositories.AlunoRepository;

@Service
public class AlunoService {
	
	@Autowired
	AlunoRepository alunoRepository;
	
	public void insert(Aluno aluno, Usuario usuarioLogado) {
		  	alunoRepository.insert(
				aluno.getMatricula(), 
				aluno.getNome(), 
				aluno.getCurso().getCodigo(), 
				aluno.getStatus().getCodigo(), 
				aluno.getTurno().getCodigo(),
				usuarioLogado.getId()); 
	}

	public Page<Aluno> findAll(Pageable pageable){
		Page<Aluno> alunos = alunoRepository.findAll(pageable);
		return alunos; 
	}
	
	public Aluno findById(Long id) {
		Optional<Aluno> obj = alunoRepository.findById(id);
		return obj.get();
	}
	
	
	public void update(Aluno alunoAtualizado, Usuario usuarioLogado) {
		alunoRepository.update(
				alunoAtualizado.getId(),
				alunoAtualizado.getMatricula(), 
				alunoAtualizado.getNome(), 
				alunoAtualizado.getCurso().getCodigo(), 
				alunoAtualizado.getStatus().getCodigo(), 
				alunoAtualizado.getTurno().getCodigo(),
				usuarioLogado.getId());
	}
	
	public void excluir(Long id) {
		alunoRepository.deleteById(id);
	}
	
	public Page<Aluno> findByStatusAtivo(Pageable pageable){
		Page<Aluno> alunos = alunoRepository.findByStatusAtivo(pageable);
		return alunos;
	}

	public Page<Aluno> findByStatusInativo(Pageable pageable){
		return alunoRepository.findByStatusInativo(pageable);
	}
	
	public Page<Aluno> findByStatusTrancado(Pageable pageable){
		return alunoRepository.findByStatusTrancado(pageable);
	}
	
	public Page<Aluno> findByStatusCancelado(Pageable pageable){
		return alunoRepository.findByStatusCancelado(pageable);
	}
	
	public Page<Aluno> findByNome(String nome, Pageable pageable){
		if(nome == null || nome.isEmpty()) {
			return alunoRepository.findAll(pageable);
		}else {
			return alunoRepository.findByNome(nome, pageable);
		}
	}
}
