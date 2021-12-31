package br.com.academy.model.services.exceptions;

public class EmailNotExistsException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	public EmailNotExistsException(String message) {
		super(message);
	}
}
