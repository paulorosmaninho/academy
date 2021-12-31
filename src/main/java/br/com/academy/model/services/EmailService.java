package br.com.academy.model.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import br.com.academy.model.dtos.EmailDto;
import br.com.academy.model.entities.Usuario;
import br.com.academy.model.services.exceptions.EmailSentException;
import br.com.util.EmailLayout;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Service
public class EmailService {
	
	private static Logger logger = LoggerFactory.getLogger(EmailService.class);
	private static String ACADEMY = "Academy";
	private static String EMAIL_REMETENTE = "paulo.rosmaninho.javaproject@gmail.com";
	private static String ASSUNTO = "Nova senha Academy";
	private static String URL_API = "https://emailsb.herokuapp.com/enviarEmail";
	
	
	public EmailDto enviarEmail(Usuario usuario) {
		
		EmailDto email = new EmailDto();
		
		email.setNomeRemetente(ACADEMY);
		email.setEmailRemetente(EMAIL_REMETENTE);
		email.setNomeDestinatario(usuario.getNome());
		email.setEmailsDestinatario(usuario.getEmail());
		email.setAssuntoEmail(ASSUNTO);
		email.setTextoEmail(EmailLayout.montarTextoEmail(email, usuario));
		
		Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
		
		String json = prettyGson.toJson(email);

		chamarApiEmail(json);
		
		return email;
	}
	
	private static Boolean chamarApiEmail(String json) {
		
		try{
		    // Cria um objeto HttpURLConnection:
			URL url = new URL(URL_API);
			
			HttpURLConnection request = (HttpURLConnection)url.openConnection();
							
			try {

	            // Define o método da requisição:
	            request.setRequestMethod("POST");

	            // Define o content-type:
	            request.setRequestProperty("Content-Type", "application/json; utf-8");
	            request.setRequestProperty("Accept", "application/json");
				
				// Define que a conexão pode enviar informações e obtê-las de volta:
	            request.setDoOutput(true);
	            request.setDoInput(true);

	            // Conecta na URL:
	            request.connect();

	            // Escreve o objeto JSON usando o OutputStream da requisição:
	            try (OutputStream outputStream = request.getOutputStream()) {
	            	byte[] input = json.getBytes("utf-8");
	            	outputStream.write(input, 0, input.length);
	            }

	            // Verifica o response code
	            Integer responseCode = request.getResponseCode();
	            String responseMessage = request.getResponseMessage();
	            
	            if(responseCode != 201) {
	            	logger.info(responseCode.toString());
	            	logger.info(responseMessage);
	            	throw new EmailSentException("Ocorreu um erro no envio do e-mail. Código: " + responseCode);
	            }
	            
	            //Recebe o response
	            try(BufferedReader br = new BufferedReader(
	            		new InputStreamReader(request.getInputStream(), "utf-8"))) {
	            	StringBuilder response = new StringBuilder();
	            	String responseLine = null;
	            	while ((responseLine = br.readLine()) != null) {
	            		response.append(responseLine.trim());
	            	}
	            	logger.info(response.toString());
	            }
	            
	        } finally {
	            request.disconnect();
	        }
	    } catch (IOException e) {
	    	logger.info(e.getMessage());
	    	throw new EmailSentException("Ocorreu um erro no envio do e-mail. Detalhes: \n\n" + e.getMessage());
	    }
		
		return true;
	}
}
