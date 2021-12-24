package br.com.academy.model.services.exceptions;

public class CriptoExistsException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public CriptoExistsException(String message) {
		super(message);
	}
}
