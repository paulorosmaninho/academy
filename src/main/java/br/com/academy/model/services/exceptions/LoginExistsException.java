package br.com.academy.model.services.exceptions;

public class LoginExistsException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public LoginExistsException(String message) {
		super(message);
	}
}
