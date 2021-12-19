package br.com.academy.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	public ModelAndView cadastrar(@Valid Aluno aluno, BindingResult br) {
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

	@GetMapping(value = "/alterar/{id}")
	public ModelAndView alterar(@PathVariable("id") Long id) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("aluno/form-alterar-aluno");
		Aluno aluno = alunoService.findById(id);
		mv.addObject("aluno", aluno);
		return mv;
	}

	@PostMapping(value = "/alterar")
	public ModelAndView alterar(Aluno aluno) {
		ModelAndView mv = new ModelAndView();
		alunoService.update(aluno);
		mv.setViewName("redirect:/alunos-cadastrados");
		return mv;
	}

	@GetMapping(value = "/excluir/{id}")
	public ModelAndView excluir(@PathVariable("id") Long id) {
		ModelAndView mv = new ModelAndView();
		alunoService.excluir(id);
		mv.setViewName("redirect:/alunos-cadastrados");
		return mv;
	}


}
