package br.com.academy.model.services.exceptions;

public class EmailSentException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	public EmailSentException(String message) {
		super(message);
	}
}
