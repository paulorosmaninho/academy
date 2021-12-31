package br.com.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

import br.com.academy.model.dtos.EmailDto;
import br.com.academy.model.entities.Usuario;

public class Util {
	
	//Classe para criptografar a senha com Hash.
	
	public static String md5(String senha) throws NoSuchAlgorithmException{
		MessageDigest md = MessageDigest.getInstance("MD5");
		BigInteger hash = new BigInteger(1, md.digest(senha.getBytes()));
		return hash.toString(16);
	}
	
	
	public static String gerarSenhaAleatoria() {
		Random aleatorio = new Random();
		String senhaAleatoria = "ACA" + aleatorio.nextInt(99999);
		return senhaAleatoria;
	}
	
}
