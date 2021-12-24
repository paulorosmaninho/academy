package br.com.academy.controllers.exceptions;

import java.time.Instant;
import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import br.com.academy.model.services.exceptions.EmailExistsException;
import br.com.academy.model.services.exceptions.LoginExistsException;

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
	 public ModelAndView emailExistsException(EmailExistsException e, HttpServletRequest request) {
		 
		 String error = "Erro no cadastro do usuário.";
		 HttpStatus status = HttpStatus.BAD_REQUEST;
		 StandardError stdError = new StandardError(Instant.now(), LocalDateTime.now(), status.value(), error, e.getMessage(), request.getRequestURI());
		 
		 ModelAndView mv = new ModelAndView();
		 
		 mv.addObject("errCode", stdError.getStatus());
		 mv.addObject("errMsg", stdError.getMessage());
		 mv.setViewName("login/form-incluir-usuario");
		 return mv;
	 }
	
	
}
