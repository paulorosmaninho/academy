package br.com.academy.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.academy.model.entities.Usuario;
import br.com.academy.model.services.UsuarioService;

@Controller
public class UsuarioController {

	@Autowired
	UsuarioService usuarioService;

	//Abre a página e instancia o objeto para receber os dados 
	@GetMapping(value = "/cadastrarUsuario")
	public ModelAndView cadastrarUsuario(Usuario usuario) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("usuario/form-incluir-usuario");
		mv.addObject("usuario", new Usuario());
		return mv;
	}


	@PostMapping(value = "/cadastrarUsuario")
	public ModelAndView cadastrarUsuario(@Valid Usuario usuario, BindingResult br, HttpSession session) throws Exception {
		ModelAndView mv = new ModelAndView();
		if(br.hasErrors()) {
			mv.setViewName("usuario/form-incluir-usuario");
			mv.addObject(usuario);
		}else {
			session.setAttribute("usuarioLogado", usuario);

			usuarioService.save(usuario);
			mv.setViewName("redirect:/");
		}
		return mv;
	}


	@GetMapping(value = "/alterarUsuario/{id}")
	public ModelAndView alterarUsuario(@PathVariable("id") Long id, HttpSession session) {
		ModelAndView mv = new ModelAndView();

		Usuario usuarioLogado = (Usuario) session.getAttribute("usuarioLogado");

		if(usuarioLogado == null) {
			mv.setViewName("login/login");
		}else {
			mv.setViewName("usuario/form-alterar-usuario");
			Usuario usuario = usuarioService.findById(id);
			mv.addObject("usuario", usuario);
		}

		return mv;
	}

	
	@PostMapping(value = "/alterarUsuario")
	public ModelAndView alterarUsuario(@Valid Usuario usuario, BindingResult br, HttpSession session) throws Exception{
		ModelAndView mv = new ModelAndView();
		Usuario usuarioLogado = (Usuario) session.getAttribute("usuarioLogado");
		
		if(usuarioLogado == null) {
			mv.setViewName("login/login");
		}else {
			if(br.hasErrors()) {
				mv.setViewName("usuario/form-alterar-usuario");
				mv.addObject(usuario);
			}
			else
			{
				usuarioService.update(usuario);
				session.setAttribute("usuarioLogado", usuario);
				mv.setViewName("home/index");
			}
		}		
		
		
		return mv;
	}


}
