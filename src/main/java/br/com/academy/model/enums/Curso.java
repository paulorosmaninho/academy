package br.com.academy.model.enums;

public enum Curso {
	ADMINISTRACAO(1),
	DIREITO(2),
	HISTORIA(3),
	MATEMATICA(4),
	BIOLOGIA(5),
	CIENCIAS_CONTABEIS(6),
	ENGENHARIA_DA_COMPUTACAO(7),
	ENGENHARIA_CIVIL(8),
	SISTEMAS_DE_INFORMACAO(9),
	MEDICINA(10);
	
	private int codigo;
	
	private Curso(int codigo) {
		this.codigo = codigo;
	}

	public int getCodigo() {
		return codigo;
	}
	
	public static Curso valueOf(int codigo) {
		
		for(Curso curso : Curso.values()) {
			if(curso.getCodigo() == codigo) {
				return curso;
			}
		}

		throw new IllegalArgumentException("Codigo do curso invalido");
	}


}
