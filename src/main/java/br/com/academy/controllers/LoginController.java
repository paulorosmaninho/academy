package br.com.academy.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.academy.model.entities.Usuario;
import br.com.academy.model.services.UsuarioService;

@Controller
public class LoginController {

	@Autowired
	UsuarioService usuarioService;
	
	@GetMapping(value = "/")
	public ModelAndView login() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("login/login");
		return mv;
	}
	
	@PostMapping(value = "/login")
	public ModelAndView login(String email, String codigoSenha, HttpSession session) throws Exception {
		ModelAndView mv = new ModelAndView();
		Usuario usuario = usuarioService.validarLogin(email, codigoSenha);
		session.setAttribute("usuarioLogado", usuario);
		mv.setViewName("home/index");
		return mv;
	}

	@PostMapping(value = "/logout")
	public ModelAndView logout(HttpSession session) {
		session.setAttribute("usuarioLogado", null);
		session.invalidate();
		return login();
	}

}
