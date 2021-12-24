package br.com.academy.model.services.exceptions;

public class EmailExistsException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	public EmailExistsException(String message) {
		super(message);
	}
}
