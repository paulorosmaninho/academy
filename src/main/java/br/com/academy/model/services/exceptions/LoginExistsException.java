package br.com.academy.model.services.exceptions;

public class LoginExistsException extends Exception {

	private static final long serialVersionUID = 1L;

	public LoginExistsException(String message) {
		super(message);
	}
}
