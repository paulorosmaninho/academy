package br.com.academy.model.enums;

public enum Status {
	
	ATIVO(1, "Ativo"),
	INATIVO(2, "Inativo"),
	TRANCADO(3, "Trancado"),
	CANCELADO(4, "Cancelado");
	
	private int codigo;
	private String descricao;
	
	private Status(int codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public int getCodigo() {
		return codigo;
	}
	
	
	public String getDescricao() {
		return descricao;
	}

	public static Status valueOf(int codigo) {
		
		for(Status status : Status.values()) {
			if(status.getCodigo() == codigo) {
				return status;
			}
		}

		throw new IllegalArgumentException("Codigo do status invalido");
	}
}
