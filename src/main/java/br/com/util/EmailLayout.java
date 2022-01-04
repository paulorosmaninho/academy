package br.com.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import br.com.academy.model.dtos.EmailDto;
import br.com.academy.model.entities.Usuario;

public class EmailLayout {

	private static final String QUEBRA_DE_LINHA_DUPLA = "&nbsp;<br>&nbsp;<br>";
	private static final String QUEBRA_DE_LINHA_UNICA = "&nbsp;<br>";
	
	public static String montarEmailBoasVindas(EmailDto email, Usuario usuario) {
		

		String dataHoraAtual = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
		
		//Criar uma tabela para centralizar as informações 
		
		StringBuilder sbTextoEmail = new StringBuilder();
		
		//Abre tabela
		sbTextoEmail.append("<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" style=\"font-family: Arial, Helvetica, sans-serif;\">");
		sbTextoEmail.append("<tr>");
		sbTextoEmail.append("<td align=\"center\">");
		sbTextoEmail.append("<table width=\"45%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">");
		sbTextoEmail.append("<tr>");
		sbTextoEmail.append("<td>");
		
		//Inicio - Texto do e-mail
		sbTextoEmail.append("<div align=\"right\">Data e hora do envio: " + dataHoraAtual + ".</div>");
		sbTextoEmail.append("<h3>Ola " + email.getNomeDestinatario() +", tudo bem?</h3>");
		sbTextoEmail.append("<h3>Seja bem-vindo ao Academy. E um prazer te-lo conosco.</h3>");
		sbTextoEmail.append("Aqui voce podera controlar os dados dos seus alunos.");
		sbTextoEmail.append(QUEBRA_DE_LINHA_UNICA);
		sbTextoEmail.append("Ha opcoes de inclusao e alteracao dos dados dos alunos. Voce tambem podera consultar por status, consultar por nome e consultar todos os alunos.");
		sbTextoEmail.append(QUEBRA_DE_LINHA_DUPLA);
		sbTextoEmail.append("Todas as consultas sao paginadas e possuem atalhos para permitir a edicao dos dados e exclusao do aluno.");
		sbTextoEmail.append(QUEBRA_DE_LINHA_DUPLA);
		sbTextoEmail.append("Voce tambem podera alterar os seus dados e a sua senha.");
		sbTextoEmail.append(QUEBRA_DE_LINHA_DUPLA);
		sbTextoEmail.append("<a target=\"_blank\" href=\"https://academysb.herokuapp.com\">Clique aqui</a> para ser direcionado a pagina de login.");
		sbTextoEmail.append(QUEBRA_DE_LINHA_DUPLA);
		sbTextoEmail.append(QUEBRA_DE_LINHA_UNICA);
		sbTextoEmail.append("<hr>");
		sbTextoEmail.append("Atenciosamente,");
		sbTextoEmail.append(QUEBRA_DE_LINHA_UNICA);
		sbTextoEmail.append("<h3>" + email.getNomeRemetente() + "</h3>");
		sbTextoEmail.append("<div align=\"justify\" style=\"background-color: #eaeded; font-size: x-small; \">");
		sbTextoEmail.append(QUEBRA_DE_LINHA_UNICA);
		sbTextoEmail.append("Enviado para: " + email.getEmailsDestinatario());
		sbTextoEmail.append(QUEBRA_DE_LINHA_DUPLA);
		sbTextoEmail.append("GitHub: https://github.com/paulorosmaninho");
		sbTextoEmail.append(QUEBRA_DE_LINHA_DUPLA);
		sbTextoEmail.append("</div>");
		//Fim - Texto do e-mail
				
		//Fecha da tabela
		sbTextoEmail.append("</td>");
		sbTextoEmail.append("</tr>");
		sbTextoEmail.append("</table>");
		sbTextoEmail.append("</td>");
		sbTextoEmail.append("<tr>");
		sbTextoEmail.append("</table>");
		
		String textoEmail = sbTextoEmail.toString();
		
		return textoEmail;
	}
	
	public static String montarEmailNovaSenha(EmailDto email, Usuario usuario) {
		
		
		String dataHoraAtual = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
		
		//Criar uma tabela para centralizar as informações 
		
		StringBuilder sbTextoEmail = new StringBuilder();
		
		//Abre tabela
		sbTextoEmail.append("<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" style=\"font-family: Arial, Helvetica, sans-serif;\">");
		sbTextoEmail.append("<tr>");
		sbTextoEmail.append("<td align=\"center\">");
		sbTextoEmail.append("<table width=\"45%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">");
		sbTextoEmail.append("<tr>");
		sbTextoEmail.append("<td>");
		
		//Inicio - Texto do e-mail
		sbTextoEmail.append("<div align=\"right\">Data e hora do envio: " + dataHoraAtual + ".</div>");
		sbTextoEmail.append("<h3>Ola " + email.getNomeDestinatario() +", tudo bem?</h3>");
		sbTextoEmail.append("<h3>Voce esta recebendo esse e-mail porque solicitou uma nova senha.</h3>");
		sbTextoEmail.append("<h4>Instrucoes:</h4>");
		sbTextoEmail.append("Assim que acessar o sistema troque a sua senha.");
		sbTextoEmail.append(QUEBRA_DE_LINHA_UNICA);
		sbTextoEmail.append("Nunca envie sua senha ou detalhes de conta por e-mail.");
		sbTextoEmail.append(QUEBRA_DE_LINHA_DUPLA);
		sbTextoEmail.append("<div style=\"background-color: #d0d3d4;\">");
		sbTextoEmail.append("<code><b>Usuario...: " + usuario.getEmail() + "</b></code>");
		sbTextoEmail.append(QUEBRA_DE_LINHA_UNICA);
		sbTextoEmail.append("<code><b>Nova Senha: " + usuario.getCodigoSenha() + "</b></code>");
		sbTextoEmail.append("</div>");
		sbTextoEmail.append(QUEBRA_DE_LINHA_DUPLA);
		sbTextoEmail.append("<a target=\"_blank\" href=\"https://academysb.herokuapp.com\">Clique aqui</a> para ser direcionado a pagina de login.");
		sbTextoEmail.append(QUEBRA_DE_LINHA_DUPLA);
		sbTextoEmail.append(QUEBRA_DE_LINHA_UNICA);
		sbTextoEmail.append("<hr>");
		sbTextoEmail.append("Atenciosamente,");
		sbTextoEmail.append(QUEBRA_DE_LINHA_UNICA);
		sbTextoEmail.append("<h3>" + email.getNomeRemetente() + "</h3>");
		sbTextoEmail.append("<div align=\"justify\" style=\"background-color: #eaeded; font-size: x-small; \">");
		sbTextoEmail.append(QUEBRA_DE_LINHA_UNICA);
		sbTextoEmail.append("Enviado para: " + email.getEmailsDestinatario());
		sbTextoEmail.append(QUEBRA_DE_LINHA_DUPLA);
		sbTextoEmail.append("GitHub: https://github.com/paulorosmaninho");
		sbTextoEmail.append(QUEBRA_DE_LINHA_DUPLA);
		sbTextoEmail.append("</div>");
		//Fim - Texto do e-mail
		
		//Fecha da tabela
		sbTextoEmail.append("</td>");
		sbTextoEmail.append("</tr>");
		sbTextoEmail.append("</table>");
		sbTextoEmail.append("</td>");
		sbTextoEmail.append("<tr>");
		sbTextoEmail.append("</table>");
		
		String textoEmail = sbTextoEmail.toString();
		
		return textoEmail;
	}

	public static String montarEmailAlteracaoSenha(EmailDto email, Usuario usuario) {
		
		
		String dataHoraAtual = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
		
		//Criar uma tabela para centralizar as informações 
		
		StringBuilder sbTextoEmail = new StringBuilder();
		
		//Abre tabela
		sbTextoEmail.append("<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" style=\"font-family: Arial, Helvetica, sans-serif;\">");
		sbTextoEmail.append("<tr>");
		sbTextoEmail.append("<td align=\"center\">");
		sbTextoEmail.append("<table width=\"45%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">");
		sbTextoEmail.append("<tr>");
		sbTextoEmail.append("<td>");
		
		//Inicio - Texto do e-mail
		sbTextoEmail.append("<div align=\"right\">Data e hora do envio: " + dataHoraAtual + ".</div>");
		sbTextoEmail.append("<h3>Ola " + email.getNomeDestinatario() +", tudo bem?</h3>");
		sbTextoEmail.append("<h3>Voce esta recebendo esse e-mail porque alterou sua senha no Academy.</h3>");
		sbTextoEmail.append("<h4>Instrucoes:</h4>");
		sbTextoEmail.append("Se voce nao reconhece essa acao. Solicite imediatamente uma nova senha atraves da tela de login opcao Esqueceu a senha.");
		sbTextoEmail.append(QUEBRA_DE_LINHA_DUPLA);
		sbTextoEmail.append("Acesse o sistema e troque a sua senha.");
		sbTextoEmail.append(QUEBRA_DE_LINHA_DUPLA);
		sbTextoEmail.append("Nunca envie sua senha ou detalhes de conta por e-mail.");
		sbTextoEmail.append(QUEBRA_DE_LINHA_DUPLA);
		sbTextoEmail.append("<a target=\"_blank\" href=\"https://academysb.herokuapp.com\">Clique aqui</a> para ser direcionado a pagina de login.");
		sbTextoEmail.append(QUEBRA_DE_LINHA_DUPLA);
		sbTextoEmail.append(QUEBRA_DE_LINHA_UNICA);
		sbTextoEmail.append("<hr>");
		sbTextoEmail.append("Atenciosamente,");
		sbTextoEmail.append(QUEBRA_DE_LINHA_UNICA);
		sbTextoEmail.append("<h3>" + email.getNomeRemetente() + "</h3>");
		sbTextoEmail.append("<div align=\"justify\" style=\"background-color: #eaeded; font-size: x-small; \">");
		sbTextoEmail.append(QUEBRA_DE_LINHA_UNICA);
		sbTextoEmail.append("Enviado para: " + email.getEmailsDestinatario());
		sbTextoEmail.append(QUEBRA_DE_LINHA_DUPLA);
		sbTextoEmail.append("GitHub: https://github.com/paulorosmaninho");
		sbTextoEmail.append(QUEBRA_DE_LINHA_DUPLA);
		sbTextoEmail.append("</div>");
		//Fim - Texto do e-mail
		
		//Fecha da tabela
		sbTextoEmail.append("</td>");
		sbTextoEmail.append("</tr>");
		sbTextoEmail.append("</table>");
		sbTextoEmail.append("</td>");
		sbTextoEmail.append("<tr>");
		sbTextoEmail.append("</table>");
		
		String textoEmail = sbTextoEmail.toString();
		
		return textoEmail;
	}
}
