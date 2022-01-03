package br.com.academy.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.com.academy.model.entities.Aluno;
import br.com.academy.model.entities.Usuario;
import br.com.academy.model.services.AlunoService;

@Controller
public class AlunoController {

	@Autowired
	AlunoService alunoService;
	
	//Abre a página e instancia o objeto para receber os dados 
	@GetMapping(value = "/cadastrarAluno")
	public ModelAndView consultarAluno(Aluno aluno, HttpSession session) {
		ModelAndView mv = new ModelAndView();
		
		Usuario usuarioLogado = (Usuario) session.getAttribute("usuarioLogado");
		
		if(usuarioLogado == null) {
			mv.setViewName("login/login");
		}else {
			mv.setViewName("aluno/form-incluir-aluno");
			mv.addObject("aluno", new Aluno());
		}
		return mv;
	}

	
	@PostMapping(value = "/cadastrarAluno")
	public ModelAndView cadastrarAluno(@Valid Aluno aluno, BindingResult br, HttpSession session) {
		ModelAndView mv = new ModelAndView();
		
		Usuario usuarioLogado = (Usuario) session.getAttribute("usuarioLogado");
		
		if(usuarioLogado == null) {
			mv.setViewName("login/login");
		}else {
			if(br.hasErrors()) {
				mv.setViewName("aluno/form-incluir-aluno");
				mv.addObject(aluno);
			}else {
				alunoService.insert(aluno, usuarioLogado);
				mv.setViewName("redirect:/alunos-por-inclusao-alteracao");
			}
		}
		return mv;
	}


	@GetMapping(value = "/alterarAluno/{id}")
	public ModelAndView alterarAluno(@PathVariable("id") Long id, HttpSession session) {
		ModelAndView mv = new ModelAndView();
		
		Usuario usuarioLogado = (Usuario) session.getAttribute("usuarioLogado");
		
		if(usuarioLogado == null) {
			mv.setViewName("login/login");
		}else {
			mv.setViewName("aluno/form-alterar-aluno");
			Aluno aluno = alunoService.findById(id);
			mv.addObject("aluno", aluno);
		}
		return mv;
	}

	
	@PostMapping(value = "/alterarAluno")
	public ModelAndView alterar(@Valid Aluno aluno, BindingResult br, HttpSession session) {
		ModelAndView mv = new ModelAndView();
		
		Usuario usuarioLogado = (Usuario) session.getAttribute("usuarioLogado");
		
		if(usuarioLogado == null) {
			mv.setViewName("login/login");
		}else {
			if(br.hasErrors()) {
				mv.setViewName("aluno/form-alterar-aluno");
				mv.addObject(aluno);
			}
			else
			{
				alunoService.update(aluno, usuarioLogado);
				mv.setViewName("redirect:/alunos-por-inclusao-alteracao");
			}
		}		
		return mv;
	}

	
	@GetMapping(value = "/excluirAluno/{id}")
	public ModelAndView excluirAluno(@PathVariable("id") Long id, HttpSession session) {
		ModelAndView mv = new ModelAndView();
		
		Usuario usuarioLogado = (Usuario) session.getAttribute("usuarioLogado");
		
		if(usuarioLogado == null) {
			mv.setViewName("login/login");
		}else {
			alunoService.excluir(id);
			mv.setViewName("redirect:/alunos-por-inclusao-alteracao");
		}
		return mv;
	}
	
	
	@GetMapping(value = "/filtro-alunos")
	public ModelAndView filtroAlunos(HttpSession session) {
		ModelAndView mv = new ModelAndView();

		Usuario usuarioLogado = (Usuario) session.getAttribute("usuarioLogado");
		
		if(usuarioLogado == null) {
			mv.setViewName("login/login");
		}else {
			mv.setViewName("aluno/filtro-alunos");
		}
		return mv;
	}

	
	//Definicao da paginacao
	//10 registros por pagina. size = 10
	//Sort pelo campo timeStampAlteracao
	//Direcao descendente
	@GetMapping(value = "/alunos-por-inclusao-alteracao")
	public ModelAndView listarAlunosPorInclusaoAlteracao(@PageableDefault(size = 10, direction = Direction.DESC, sort = "timeStampAlteracao") Pageable pageable, 
			HttpSession session) {
		
		ModelAndView mv = new ModelAndView();

		Usuario usuarioLogado = (Usuario) session.getAttribute("usuarioLogado");
		
		if(usuarioLogado == null) {
			mv.setViewName("login/login");
		}else {
			
			Page<Aluno> alunos = alunoService.findAll(pageable);
			
			mv.addObject("alunos", alunos);
			mv.addObject("paginaAtual", pageable.getPageNumber());
			mv.setViewName("aluno/list-alunos-inclusao-alteracao");
		}
		return mv;
	}

	
	//Definicao da paginacao
	//10 registros por pagina. size = 10
	//Sort pelo campo nome
	//Direcao ascendente
	@GetMapping(value = "/alunos-ativos")
	public ModelAndView listarAlunosAtivos(@PageableDefault(size = 10, direction = Direction.ASC, sort = "nome") Pageable pageable, 
			HttpSession session) {
		
		ModelAndView mv = new ModelAndView();
		
		Usuario usuarioLogado = (Usuario) session.getAttribute("usuarioLogado");
		
		if(usuarioLogado == null) {
			mv.setViewName("login/login");
		}else {
			
			Page<Aluno> alunos = alunoService.findByStatusAtivo(pageable);
			
			mv.addObject("alunos", alunos);
			mv.addObject("paginaAtual", pageable.getPageNumber());
			mv.setViewName("aluno/list-alunos-ativos");
		}
		return mv;
	}
	
	
	//Definicao da paginacao
	//10 registros por pagina. size = 10
	//Sort pelo campo nome
	//Direcao ascendente
	@GetMapping(value = "/alunos-inativos")
	public ModelAndView listarAlunosInativos(@PageableDefault(size = 10, direction = Direction.ASC, sort = "nome") Pageable pageable, 
			HttpSession session) {
		ModelAndView mv = new ModelAndView();
		
		Usuario usuarioLogado = (Usuario) session.getAttribute("usuarioLogado");
		
		if(usuarioLogado == null) {
			mv.setViewName("login/login");
		}else {
			Page<Aluno> alunos = alunoService.findByStatusInativo(pageable);
			
			mv.addObject("alunos", alunos);
			mv.addObject("paginaAtual", pageable.getPageNumber());
			mv.setViewName("aluno/list-alunos-inativos");
		}
		return mv;
	}

	
	//Definicao da paginacao
	//10 registros por pagina. size = 10
	//Sort pelo campo nome
	//Direcao ascendente
	@GetMapping(value = "/alunos-trancados")
	public ModelAndView listarAlunosTrancados(@PageableDefault(size = 10, direction = Direction.ASC, sort = "nome") Pageable pageable, 
			HttpSession session) {
		ModelAndView mv = new ModelAndView();
		
		Usuario usuarioLogado = (Usuario) session.getAttribute("usuarioLogado");
		
		if(usuarioLogado == null) {
			mv.setViewName("login/login");
		}else {
			
			Page<Aluno> alunos = alunoService.findByStatusTrancado(pageable);
			
			mv.addObject("alunos", alunos);
			mv.addObject("paginaAtual", pageable.getPageNumber());
			mv.setViewName("aluno/list-alunos-trancados");
		}
		return mv;
	}
	
	
	//Definicao da paginacao
	//10 registros por pagina. size = 10
	//Sort pelo campo nome
	//Direcao ascendente
	@GetMapping(value = "/alunos-cancelados")
	public ModelAndView listarAlunosCancelados(@PageableDefault(size = 10, direction = Direction.ASC, sort = "nome") Pageable pageable, 
			HttpSession session) {
		ModelAndView mv = new ModelAndView();
		
		Usuario usuarioLogado = (Usuario) session.getAttribute("usuarioLogado");
		
		if(usuarioLogado == null) {
			mv.setViewName("login/login");
		}else {
			
			Page<Aluno> alunos = alunoService.findByStatusCancelado(pageable);
			
			mv.addObject("alunos", alunos);
			mv.addObject("paginaAtual", pageable.getPageNumber());
			mv.setViewName("aluno/list-alunos-cancelados");
		}
		return mv;
	}


	@GetMapping(value = "/alunos-por-nome")
	public ModelAndView listarAlunosPorNome(@RequestParam(required = false) String nome, 
			@PageableDefault(size = 10, direction = Direction.ASC, sort = "nome") Pageable pageable, 
			HttpSession session) {
		
		ModelAndView mv = new ModelAndView();
		
		Usuario usuarioLogado = (Usuario) session.getAttribute("usuarioLogado");
		
		if(usuarioLogado == null) {
			mv.setViewName("login/login");
		}else {

			Page<Aluno> alunos = alunoService.findByNome(nome, pageable);
			
			mv.addObject("nome", nome);
			mv.addObject("alunos", alunos);
			mv.addObject("paginaAtual", pageable.getPageNumber());
			mv.setViewName("aluno/list-alunos-por-nome");
		}
		return mv;
	}
}
