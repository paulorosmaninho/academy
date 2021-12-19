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
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

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

	@Column(name = "cd_matricula", length = 15)
	@NotBlank(message = "A matrícula não foi preenchida. Por favor clique no botão Gerar.")
	private String matricula;

	@Size(min = 2, max = 80, message = "O nome do aluno deve ter no mínimo 2 caracteres.")
	@Column(name = "nm_aluno", length = 80)
	private String nome;

	@Column(name = "cd_curso")
	private Integer curso;

	@Column(name = "cd_status")
	private Integer status;

	@Column(name = "cd_turno")
	private Integer turno;

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

	public Aluno(Long id, String matricula, String nome, Curso curso, Status status, Turno turno,
			Calendar timeStampInclusao, Calendar timeStampAlteracao) {
		super();
		this.id = id;
		this.matricula = matricula;
		this.nome = nome;
		setCurso(curso);
		setStatus(status);
		setTurno(turno);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Curso getCurso() {
		if(this.curso != null) {
			return Curso.valueOf(this.curso);
		}
		return null;
	}

	public void setCurso(Curso curso) {
		if (curso != null) {
			this.curso = curso.getCodigo();
		}
	}

	public Status getStatus() {
		if(this.status !=null) {
			return Status.valueOf(this.status);
		}
		return null;
	}

	public void setStatus(Status status) {
		if (status != null) {
			this.status = status.getCodigo();
		}
	}

	public Turno getTurno() {
		if(this.turno!=null) {
			return Turno.valueOf(turno);
		}
		return null;
	}

	public void setTurno(Turno turno) {
		if (turno != null) {
			this.turno = turno.getCodigo();
		}
	}
	
	public Calendar getTimeStampInclusao() {
		return timeStampInclusao;
	}

	public void setTimeStampInclusao(Calendar timeStampInclusao) {
		this.timeStampInclusao = timeStampInclusao;
	}

	public Calendar getTimeStampAlteracao() {
		return timeStampAlteracao;
	}

	public void setTimeStampAlteracao(Calendar timeStampAlteracao) {
		this.timeStampAlteracao = timeStampAlteracao;
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
