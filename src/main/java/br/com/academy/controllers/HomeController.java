package br.com.academy.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.academy.model.entities.Aluno;

@Controller
public class HomeController {
	
//	@GetMapping(value = "/index")
//	public ModelAndView index() {
//		ModelAndView mv = new ModelAndView();
//		mv.setViewName("home/index");
//		mv.addObject("aluno",new Aluno());
//		return mv;
//	}

}
