package br.com.academy.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import br.com.academy.model.entities.Aluno;
import br.com.academy.model.entities.Usuario;

@Controller
public class HomeController {
	
	@GetMapping(value = "/index")
	public ModelAndView index(HttpSession session) {
		ModelAndView mv = new ModelAndView();
		
		Usuario usuarioLogado = (Usuario) session.getAttribute("usuarioLogado");
		
		if(usuarioLogado == null) {
			mv.setViewName("login/login");
		}else {
			mv.setViewName("home/index");
			mv.addObject("aluno",new Aluno());
		}
		return mv;
	}

}
