package br.com.academy.model.enums;

public enum Curso {
	ADMINISTRACAO(1, "Administração"),
	DIREITO(2, "Direito"),
	HISTORIA(3, "História"),
	MATEMATICA(4, "Matemática"),
	BIOLOGIA(5, "Biologia"),
	CIENCIAS_CONTABEIS(6, "Ciências Contábeis"),
	ENGENHARIA_DA_COMPUTACAO(7, "Engenharia da Computação"),
	ENGENHARIA_CIVIL(8, "Engenharia Civil"),
	SISTEMAS_DE_INFORMACAO(9, "Sistemas de Informação"),
	MEDICINA(10, "Medicina");
	
	private int codigo;
	private String descricao;
	
	private Curso(int codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public int getCodigo() {
		return codigo;
	}
	
	public String getDescricao() {
		return descricao;
	}

	public static Curso valueOf(int codigo) {
		
		for(Curso curso : Curso.values()) {
			if(curso.getCodigo() == codigo) {
				return curso;
			}
		}

		throw new IllegalArgumentException("Codigo do curso invalido");
	}

	public static String descricaoCurso(int codigo) {
		
		for(Curso curso : Curso.values()) {
			if(curso.getCodigo() == codigo) {
				return curso.getDescricao();
			}
		}
		
		throw new IllegalArgumentException("Codigo do curso invalido");
	}
}
