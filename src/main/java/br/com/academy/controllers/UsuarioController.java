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
import br.com.academy.model.services.EmailService;
import br.com.academy.model.services.UsuarioService;

@Controller
public class UsuarioController {

	private static final String BOAS_VINDAS_AO_ACADEMY = "Boas Vindas ao Academy";
	private static final String ALTERACAO_DE_SENHA_NO_ACADEMY = "Alteracao de senha no Academy";
	private static final String ALTERACAO_REALIZADA_COM_SUCESSO = "Alteração realizada com sucesso!";
	private static final String CADASTRO_REALIZADO_COM_SUCESSO = "Sucesso! Volte à página de login para acessar o sistema.";
	
	@Autowired
	UsuarioService usuarioService;
	
	@Autowired
	EmailService emailService;


	//Abre a página e instancia o objeto para receber os dados 
	@GetMapping(value = "/cadastrarUsuario")
	public ModelAndView cadastrarUsuario(Usuario usuario) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("usuario/form-incluir-usuario");
		mv.addObject("usuario", new Usuario());
		return mv;
	}


	@PostMapping(value = "/cadastrarUsuario")
	public ModelAndView cadastrarUsuario(@Valid Usuario usuario, BindingResult br, HttpSession session){
		ModelAndView mv = new ModelAndView();
		
		if(br.hasErrors()) {
			mv.setViewName("usuario/form-incluir-usuario");
			mv.addObject(usuario);
		}else {
			
			session.setAttribute("usuarioLogado", usuario);

			usuarioService.save(usuario);
			
			//Enviar e-mail de boas vindas para usuario
			String assunto = BOAS_VINDAS_AO_ACADEMY;
			emailService.enviarEmail(usuario, assunto);

			//Retorna para a pagina
			String sucesso = CADASTRO_REALIZADO_COM_SUCESSO;
			mv.addObject("sucesso", sucesso);
			mv.addObject("usuario", usuario);
			mv.setViewName("usuario/form-incluir-usuario");
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
	public ModelAndView alterarUsuario(@Valid Usuario usuario, BindingResult br, HttpSession session){
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
				//Verifica se houve alteracao de senha
				if(usuario.getCodigoSenha() != null && !usuario.getCodigoSenha().isEmpty()) {
					String assunto = ALTERACAO_DE_SENHA_NO_ACADEMY;
					emailService.enviarEmail(usuario, assunto);
				}

				//Atualiza os dados do usuario
				usuarioService.update(usuario);
				
				//Pesquisa o usuario para obter os dados de auditoria atualizados
				usuario = usuarioService.findById(usuario.getId());
				
				//Atualiza a sessao
				session.setAttribute("usuarioLogado", usuario);

				
				//Retorna para a página com os dados atualizados
				String sucesso = ALTERACAO_REALIZADA_COM_SUCESSO;
				mv.addObject("usuario", usuario);
				mv.addObject("sucesso", sucesso);
				mv.setViewName("usuario/form-alterar-usuario");
			}
		}		
		return mv;
	}
}
