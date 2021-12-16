package br.com.academy.model.entities;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import br.com.academy.model.enums.Curso;
import br.com.academy.model.enums.Status;
import br.com.academy.model.enums.Turno;

@Entity
@Table(name = "tb_aluno")
public class Aluno {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "nm_aluno", length = 80)
	private String nome;
	
	@Column(name = "cd_curso")
	private Integer curso;

	@Column(name = "cd_matricula", length = 15)
	private String matricula;

	@Column(name = "ds_status", length = 15)
	private Status status;

	@Column(name = "ds_turno", length = 15)
	private Turno turno;
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "ts_inclusao")
	private Calendar timeStampInclusao;
	
	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "ts_alteracao")
	private Calendar timeStampAlteracao;

	
	public Aluno() {
	}

	public Aluno(Long id, String nome, Curso curso, String matricula, Status status, Turno turno) {
		super();
		this.id = id;
		this.nome = nome;
		setCurso(curso);
		this.matricula = matricula;
		this.status = status;
		this.turno = turno;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public Curso getCurso() {
		return Curso.valueOf(curso);
	}

	public void setCurso(Curso curso) {
		if(curso != null) {
			this.curso = curso.getCodigo();
		}
	}


	public String getMatricula() {
		return matricula;
	}


	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}


	public Status getStatus() {
		return status;
	}


	public void setStatus(Status status) {
		this.status = status;
	}


	public Turno getTurno() {
		return turno;
	}


	public void setTurno(Turno turno) {
		this.turno = turno;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aluno other = (Aluno) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
