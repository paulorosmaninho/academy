package br.com.academy.model.entities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "tb_usuario")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_usuario")
	private Long id;
	
	@Column(name = "nm_nome", length = 80)
	@Size(min = 2, max = 80, message = "O nome do usuário deve conter no mínimo 2 e máximo 80 caracteres.")
	private String nome;

	@Column(name = "nm_sobrenome", length = 80)
	@Size(min = 2, max = 80, message = "O sobrenome do usuário deve conter no mínimo 2 e máximo 80 caracteres.")
	private String sobrenome;

	@Email(message = "Informe um e-mail válido. Exemplo: nome@email.com.")
	@Size(min = 7, message = "Informe um e-mail válido. Exemplo: nome@email.com.")
	@Size(max = 255, message = "O e-mail deve conter até 255 caracteres.")
	@Column(name = "nm_email")
	private String email;

	@Column(name = "cd_senha")
	private String codigoSenha;
	
	@OneToMany(mappedBy = "usuario")
	private List<Aluno> alunos = new ArrayList<>();
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "ts_inclusao")
	private Calendar timeStampInclusao;

	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "ts_alteracao")
	private Calendar timeStampAlteracao;

	
	public Usuario() {
	}


	public Usuario(Long id, String nome, String sobrenome, String email, String codigoSenha) {
		super();
		this.id = id;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.email = email;
		this.codigoSenha = codigoSenha;
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

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCodigoSenha() {
		return codigoSenha;
	}

	public void setCodigoSenha(String codigoSenha) {
		this.codigoSenha = codigoSenha;
	}
	
	public List<Aluno> getAlunos() {
		return alunos;
	}

	public Calendar getTimeStampInclusao() {
		return timeStampInclusao;
	}

	public Calendar getTimeStampAlteracao() {
		return timeStampAlteracao;
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
		Usuario other = (Usuario) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
