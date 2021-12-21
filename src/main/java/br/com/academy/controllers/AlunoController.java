package br.com.academy.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.com.academy.model.entities.Aluno;
import br.com.academy.model.services.AlunoService;

@Controller
public class AlunoController {

	@Autowired
	AlunoService alunoService;

	//Abre a página e instancia o objeto para receber os dados 
	@GetMapping(value = "/cadastrarAluno")
	public ModelAndView consultarAluno(Aluno aluno) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("aluno/form-aluno");
		mv.addObject("aluno", new Aluno());
		return mv;
	}

	@PostMapping(value = "/cadastrarAluno")
	public ModelAndView cadastrarAluno(@Valid Aluno aluno, BindingResult br) {
		ModelAndView mv = new ModelAndView();
		if(br.hasErrors()) {
			mv.setViewName("aluno/form-aluno");
			mv.addObject(aluno);
		}else {
			alunoService.insert(aluno);
			mv.setViewName("redirect:/alunos-cadastrados");
		}
		return mv;
	}

	@GetMapping(value = "/alunos-cadastrados")
	public ModelAndView listarAlunos() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("aluno/list-alunos");
		mv.addObject("listaAlunos", alunoService.findAll());
		return mv;
	}

	@GetMapping(value = "/alterarAluno/{id}")
	public ModelAndView alterarAluno(@PathVariable("id") Long id) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("aluno/form-alterar-aluno");
		Aluno aluno = alunoService.findById(id);
		mv.addObject("aluno", aluno);
		return mv;
	}

	@PostMapping(value = "/alterarAluno")
	public ModelAndView alterar(@Valid Aluno aluno, BindingResult br) {
		ModelAndView mv = new ModelAndView();
		if(br.hasErrors()) {
			mv.setViewName("aluno/form-alterar-aluno");
			mv.addObject(aluno);
		}
		else
		{
			alunoService.update(aluno);
			mv.setViewName("redirect:/alunos-cadastrados");
		}
		return mv;
	}

	@GetMapping(value = "/excluirAluno/{id}")
	public ModelAndView excluirAluno(@PathVariable("id") Long id) {
		ModelAndView mv = new ModelAndView();
		alunoService.excluir(id);
		mv.setViewName("redirect:/alunos-cadastrados");
		return mv;
	}
	
	@GetMapping(value = "/filtro-alunos")
	public ModelAndView filtroAlunos() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("aluno/filtro-alunos");
		return mv;
	}

	@GetMapping(value = "/alunos-ativos")
	public ModelAndView listarAlunosAtivos() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("aluno/list-alunos-ativos");
		mv.addObject("listaAlunosAtivos", alunoService.findByStatusAtivo());
		return mv;
	}
	
	@GetMapping(value = "/alunos-inativos")
	public ModelAndView listarAlunosInativos() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("aluno/list-alunos-inativos");
		mv.addObject("listaAlunosInativos", alunoService.findByStatusInativo());
		return mv;
	}
	
	@GetMapping(value = "/alunos-trancados")
	public ModelAndView listarAlunosTrancados() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("aluno/list-alunos-trancados");
		mv.addObject("listaAlunosTrancados", alunoService.findByStatusTrancado());
		return mv;
	}
	
	@GetMapping(value = "/alunos-cancelados")
	public ModelAndView listarAlunosCancelados() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("aluno/list-alunos-cancelados");
		mv.addObject("listaAlunosCancelados", alunoService.findByStatusCancelado());
		return mv;
	}

	@GetMapping(value = "/alunos-indefinidos")
	public ModelAndView listarAlunosIndefinidos() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("aluno/list-alunos-indefinidos");
		mv.addObject("listaAlunosIndefinidos", alunoService.findByStatusIndefinido());
		return mv;
	}

	@PostMapping(value = "/alunos-por-nome")
	public ModelAndView listarAlunosPorNome(@RequestParam(required = false) String nome) {
		ModelAndView mv = new ModelAndView();
//		mv.setViewName("aluno/filtro-alunos");
		mv.setViewName("aluno/list-alunos-por-nome");
		mv.addObject("listaAlunosPorNome", alunoService.findByNome(nome));
		return mv;
	}


}
