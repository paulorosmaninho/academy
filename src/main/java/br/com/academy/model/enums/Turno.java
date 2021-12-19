package br.com.academy.model.enums;

public enum Turno {
	
	MANHA(1, "Manhã"),
	TARDE(2, "Tarde"),
	NOITE(3, "Noite");
	
	private int codigo;
	private String descricao;
	
	private Turno(int codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public int getCodigo() {
		return codigo;
	}
	
	
	public String getDescricao() {
		return descricao;
	}

	public static Turno valueOf(int codigo) {
		
		for(Turno turno : Turno.values()) {
			if(turno.getCodigo() == codigo) {
				return turno;
			}
		}

		throw new IllegalArgumentException("Codigo do turno invalido");
	}
}
