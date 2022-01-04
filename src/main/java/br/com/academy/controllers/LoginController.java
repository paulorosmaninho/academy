package br.com.academy.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.academy.model.entities.Usuario;
import br.com.academy.model.services.EmailService;
import br.com.academy.model.services.UsuarioService;

@Controller
public class LoginController {

	private static final String NOVA_SENHA_ACADEMY = "Nova senha Academy";
	private static final String EMAIL_ENVIADO_COM_SUCESSO = "E-mail enviado com sucesso";
	
	@Autowired
	UsuarioService usuarioService;
	
	@Autowired
	EmailService emailService;
	
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
	
	
	@GetMapping(value = "/novaSenha")
	public ModelAndView novaSenha() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("login/nova-senha");
		return mv;
	}

	
	@PostMapping(value = "/novaSenha")
	public ModelAndView novaSenha(String email) {
		ModelAndView mv = new ModelAndView();
		
		//Gerar a nova senha
		Usuario usuario = usuarioService.novaSenha(email);
		
		String novaSenha = usuario.getCodigoSenha();
		
		//Atualizar banco de dados com a nova senha
		usuario = usuarioService.update(usuario);
		
		//Define senha sem hash para enviar e-mail
		usuario.setCodigoSenha(novaSenha);
		
		//Enviar e-mail para o usuario
		String assunto = NOVA_SENHA_ACADEMY;
		emailService.enviarEmail(usuario, assunto);

		//Retorna para a pagina
		String sucesso = EMAIL_ENVIADO_COM_SUCESSO;
		mv.addObject("sucesso", sucesso);
		mv.setViewName("login/nova-senha");
		return mv;
	}
}
