package br.com.academy.controllers.exceptions;

import java.time.Instant;
import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import br.com.academy.model.entities.Usuario;
import br.com.academy.model.services.exceptions.EmailExistsException;
import br.com.academy.model.services.exceptions.EmailNotExistsException;
import br.com.academy.model.services.exceptions.EmailSentException;
import br.com.academy.model.services.exceptions.LoginExistsException;
import br.com.academy.model.services.exceptions.SenhaIncompletaExceptionAlteracao;
import br.com.academy.model.services.exceptions.SenhaIncompletaExceptionInclusao;

@ControllerAdvice
public class ResourceExceptionHandler {
	
	 @ExceptionHandler(LoginExistsException.class)
	    public ModelAndView loginExistsException(LoginExistsException e, HttpServletRequest request) {

			String error = "Erro no login.";
			HttpStatus status = HttpStatus.BAD_REQUEST;
			StandardError stdError = new StandardError(Instant.now(), LocalDateTime.now(), status.value(), error, e.getMessage(), request.getRequestURI());

	        ModelAndView mv = new ModelAndView();
	        
	        mv.addObject("errCode", stdError.getStatus());
	        mv.addObject("errMsg", stdError.getMessage());
	        mv.setViewName("login/login");
	        return mv;
	    }

	 @ExceptionHandler(EmailExistsException.class)
	 public ModelAndView emailExistsException(EmailExistsException e, HttpServletRequest request, HttpSession session) {
		 
		 String error = "Erro no cadastro do usuário.";
		 HttpStatus status = HttpStatus.BAD_REQUEST;
		 StandardError stdError = new StandardError(Instant.now(), LocalDateTime.now(), status.value(), error, e.getMessage(), request.getRequestURI());
		 
		 ModelAndView mv = new ModelAndView();
		 
		 Usuario usuario = (Usuario) session.getAttribute("usuarioLogado");
		 
		 mv.addObject(usuario);
		 mv.addObject("errCode", stdError.getStatus());
		 mv.addObject("errMsg", stdError.getMessage());
		 mv.setViewName("usuario/form-incluir-usuario");
		 return mv;
	 }

	 @ExceptionHandler(EmailNotExistsException.class)
	 public ModelAndView emailNotExistsException(EmailNotExistsException e, HttpServletRequest request) {
		 
		 String error = "Erro. E-mail não cadastrado.";
		 HttpStatus status = HttpStatus.BAD_REQUEST;
		 StandardError stdError = new StandardError(Instant.now(), LocalDateTime.now(), status.value(), error, e.getMessage(), request.getRequestURI());
		 
		 ModelAndView mv = new ModelAndView();
		 
		 mv.addObject("errCode", stdError.getStatus());
		 mv.addObject("errMsg", stdError.getMessage());
		 mv.setViewName("login/nova-senha");
		 return mv;
	 }

	 @ExceptionHandler(EmailSentException.class)
	 public ModelAndView emailSentException(EmailSentException e, HttpServletRequest request) {
		 
		 String error = "Erro no envio do e-mail";
		 HttpStatus status = HttpStatus.BAD_REQUEST;
		 StandardError stdError = new StandardError(Instant.now(), LocalDateTime.now(), status.value(), error, e.getMessage(), request.getRequestURI());
		 
		 ModelAndView mv = new ModelAndView();
		 
		 mv.addObject("errCode", stdError.getStatus());
		 mv.addObject("errMsg", stdError.getMessage());
		 mv.setViewName("login/nova-senha");
		 return mv;
	 }

	 @ExceptionHandler(SenhaIncompletaExceptionInclusao.class)
	 public ModelAndView senhaIncompletaExceptionInclusao(SenhaIncompletaExceptionInclusao e, HttpServletRequest request, HttpSession session) {
		 
		 String error = "Senha com menos de 8 caracteres.";
		 HttpStatus status = HttpStatus.BAD_REQUEST;
		 StandardError stdError = new StandardError(Instant.now(), LocalDateTime.now(), status.value(), error, e.getMessage(), request.getRequestURI());
		 
		 ModelAndView mv = new ModelAndView();
		 
		 Usuario usuario = (Usuario) session.getAttribute("usuarioLogado");
		 
		 mv.addObject(usuario);
		 mv.addObject("errCode", stdError.getStatus());
		 mv.addObject("errMsgSenha", stdError.getMessage());
		 mv.setViewName("usuario/form-incluir-usuario");
		 return mv;
	 }

	 @ExceptionHandler(SenhaIncompletaExceptionAlteracao.class)
	 public ModelAndView senhaIncompletaExceptionAlteracao(SenhaIncompletaExceptionAlteracao e, HttpServletRequest request, HttpSession session) {
		 
		 String error = "Senha com menos de 8 caracteres.";
		 HttpStatus status = HttpStatus.BAD_REQUEST;
		 StandardError stdError = new StandardError(Instant.now(), LocalDateTime.now(), status.value(), error, e.getMessage(), request.getRequestURI());
		 
		 ModelAndView mv = new ModelAndView();
		 
		 Usuario usuario = (Usuario) session.getAttribute("usuarioLogado");
		 
		 mv.addObject(usuario);
		 mv.addObject("errCode", stdError.getStatus());
		 mv.addObject("errMsgSenha", stdError.getMessage());
		 mv.setViewName("usuario/form-alterar-usuario");
		 return mv;
	 }
}
