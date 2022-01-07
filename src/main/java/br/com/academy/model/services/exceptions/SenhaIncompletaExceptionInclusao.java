package br.com.academy.model.services.exceptions;

public class SenhaIncompletaExceptionInclusao extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public SenhaIncompletaExceptionInclusao(String message) {
		super(message);
	}
}
