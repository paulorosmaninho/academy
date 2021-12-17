package br.com.academy.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.academy.model.entities.Aluno;
import br.com.academy.model.services.AlunoService;

@Controller
public class AlunoController {
	
	@Autowired
	AlunoService alunoService;
	
	@GetMapping(value = "/cadastrar")
	public ModelAndView consultar(Aluno aluno) {
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("aluno/form-aluno");
		mv.addObject("aluno", new Aluno());
		
		return mv;
	}
	
	@PostMapping(value = "/cadastrar")
	public ModelAndView cadastrar(Aluno aluno) {
		ModelAndView mv = new ModelAndView();
		alunoService.insert(aluno);
		mv.setViewName("redirect:/alunos-cadastrados");
		return mv;
	}
	
	@GetMapping(value = "/alunos-cadastrados")
	public ModelAndView listarAlunos() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("aluno/list-alunos");
		mv.addObject("listaAlunos", alunoService.findAll());
		return mv;
	}

}
