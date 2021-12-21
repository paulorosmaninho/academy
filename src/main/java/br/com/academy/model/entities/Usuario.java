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
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "tb_usuario")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "cd_usuario", length = 15)
	@Size(min = 4, max = 15, message = "O código do usuário deve conter no mínimo 3 e máximo 15 caracteres.")
	private String codigoUsuario;

	@Email
	@Column(name = "nm_email")
	private String email;

	@Column(name = "cd_senha")
	private String codigoSenha;
	
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

	public Usuario(Long id, String codigoUsuario, String email, String codigoSenha) {
		super();
		this.id = id;
		this.codigoUsuario = codigoUsuario;
		this.email = email;
		this.codigoSenha = codigoSenha;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodigoUsuario() {
		return codigoUsuario;
	}

	public void setCodigoUsuario(String codigoUsuario) {
		this.codigoUsuario = codigoUsuario;
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
