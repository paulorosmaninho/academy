package br.com.academy.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.academy.model.entities.Usuario;
import br.com.academy.model.services.UsuarioService;

@Controller
public class UsuarioController {
	
	@Autowired
	UsuarioService usuarioService;
	
	
	@GetMapping("/")
	public ModelAndView login() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("login/login");
		return mv;
	}
	
	//Abre a página e instancia o objeto para receber os dados 
	@GetMapping(value = "/cadastrarUsuario")
	public ModelAndView cadastrarUsuario(Usuario usuario) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("login/form-usuario");
		mv.addObject("usuario", new Usuario());
		return mv;
	}

	
	@PostMapping(value = "/cadastrarUsuario")
	public ModelAndView cadastrarUsuario(@Valid Usuario usuario, BindingResult br) throws Exception {
		ModelAndView mv = new ModelAndView();
		if(br.hasErrors()) {
			mv.setViewName("login/form-usuario");
			mv.addObject(usuario);
		}else {

			usuarioService.save(usuario);
			mv.setViewName("redirect:/");
		}
		return mv;
	}
	

}
