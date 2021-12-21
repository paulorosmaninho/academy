package br.com.academy.model.services;

import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.academy.model.entities.Usuario;
import br.com.academy.model.services.exceptions.CriptoExistsException;
import br.com.academy.model.services.exceptions.EmailExistsException;
import br.com.academy.repositories.UsuarioRepository;
import br.com.util.Util;

@Service
public class UsuarioService {

	@Autowired
	UsuarioRepository usuarioRepository;
	
	public Usuario save(Usuario usuario) throws Exception{
		try {
			
			if(usuarioRepository.findByEmail(usuario.getEmail()) != null) {
				
				throw new EmailExistsException("Este e-mail já está cadastrado: " + usuario.getEmail());
			}
			//Criptografa a senha
			usuario.setCodigoSenha(Util.md5(usuario.getCodigoSenha()));

			//Salva o usuario na base
			usuarioRepository.save(usuario);
			
		}catch(NoSuchAlgorithmException e) {
			throw new CriptoExistsException("Ocorreu um erro na criptografia da senha.");
		}
		
		return usuarioRepository.save(usuario);
	}
	
	

}
