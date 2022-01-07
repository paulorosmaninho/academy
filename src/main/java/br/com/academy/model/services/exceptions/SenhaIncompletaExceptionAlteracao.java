package br.com.academy.model.services.exceptions;

public class SenhaIncompletaExceptionAlteracao extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public SenhaIncompletaExceptionAlteracao(String message) {
		super(message);
	}
}
