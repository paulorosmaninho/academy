package br.com.academy.model.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.academy.model.entities.Aluno;
import br.com.academy.repositories.AlunoRepository;

@Service
public class AlunoService {
	
	@Autowired
	AlunoRepository alunoRepository;
	
	public void insert(Aluno aluno) {
		  	alunoRepository.insert(
				aluno.getMatricula(), 
				aluno.getNome(), 
				aluno.getCurso().getCodigo(), 
				aluno.getStatus().getCodigo(), 
				aluno.getTurno().getCodigo()); 
	}

	public List<Aluno> findAll(){
		List<Aluno> alunos = alunoRepository.findAll();
		return alunos; 
	}
	
	public Aluno findById(Long id) {
		Optional<Aluno> obj = alunoRepository.findById(id);
//		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
//		Tratar erro aqui
		return obj.get();
	}
	
	
	public void update(Aluno alunoAtualizado) {
		alunoRepository.update(
				alunoAtualizado.getId(),
				alunoAtualizado.getMatricula(), 
				alunoAtualizado.getNome(), 
				alunoAtualizado.getCurso().getCodigo(), 
				alunoAtualizado.getStatus().getCodigo(), 
				alunoAtualizado.getTurno().getCodigo());
	}
	
	public void excluir(Long id) {
		alunoRepository.deleteById(id);
	}
	
	public List<Aluno> findByStatusAtivo(){
		return alunoRepository.findByStatusAtivo();
	}

	public List<Aluno> findByStatusInativo(){
		return alunoRepository.findByStatusInativo();
	}
	
	public List<Aluno> findByStatusTrancado(){
		return alunoRepository.findByStatusTrancado();
	}
	
	public List<Aluno> findByStatusCancelado(){
		return alunoRepository.findByStatusCancelado();
	}
	
	public List<Aluno> findByStatusIndefinido(){
		return alunoRepository.findByStatusIndefinido();
	}

	public List<Aluno> findByNome(String nome){
		if(nome == null || nome.isBlank() || nome.isEmpty()) {
			return alunoRepository.findAll();
		}else {
			return alunoRepository.findByNome(nome);
		}
	}

}
