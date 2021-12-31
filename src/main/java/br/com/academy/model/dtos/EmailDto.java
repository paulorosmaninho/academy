package br.com.academy.model.dtos;

import org.springframework.data.repository.NoRepositoryBean;

public class EmailDto {
	
	private String nomeRemetente;
	private String emailRemetente;
	private String nomeDestinatario;
	private String emailsDestinatario;
	private String assuntoEmail;
	private String textoEmail;
	

	public EmailDto() {
	}

	public EmailDto(String nomeRemetente, String emailRemetente, String nomeDestinatario, String emailsDestinatario,
			String assuntoEmail, String textoEmail) {
		super();
		this.nomeRemetente = nomeRemetente;
		this.emailRemetente = emailRemetente;
		this.nomeDestinatario = nomeDestinatario;
		this.emailsDestinatario = emailsDestinatario;
		this.assuntoEmail = assuntoEmail;
		this.textoEmail = textoEmail;
	}


	public String getNomeRemetente() {
		return nomeRemetente;
	}

	public void setNomeRemetente(String nomeRemetente) {
		this.nomeRemetente = nomeRemetente;
	}

	public String getEmailRemetente() {
		return emailRemetente;
	}

	public void setEmailRemetente(String emailRemetente) {
		this.emailRemetente = emailRemetente;
	}

	public String getNomeDestinatario() {
		return nomeDestinatario;
	}

	public void setNomeDestinatario(String nomeDestinatario) {
		this.nomeDestinatario = nomeDestinatario;
	}

	public String getEmailsDestinatario() {
		return emailsDestinatario;
	}

	public void setEmailsDestinatario(String emailsDestinatario) {
		this.emailsDestinatario = emailsDestinatario;
	}

	public String getAssuntoEmail() {
		return assuntoEmail;
	}

	public void setAssuntoEmail(String assuntoEmail) {
		this.assuntoEmail = assuntoEmail;
	}

	public String getTextoEmail() {
		return textoEmail;
	}

	public void setTextoEmail(String textoEmail) {
		this.textoEmail = textoEmail;
	}
}
