package br.com.academy.model.services;

import java.security.NoSuchAlgorithmException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.academy.model.entities.Usuario;
import br.com.academy.model.services.exceptions.CriptoExistsException;
import br.com.academy.model.services.exceptions.EmailExistsException;
import br.com.academy.model.services.exceptions.EmailNotExistsException;
import br.com.academy.model.services.exceptions.LoginExistsException;
import br.com.academy.repositories.UsuarioRepository;
import br.com.util.Util;

@Service
public class UsuarioService {

	@Autowired
	UsuarioRepository usuarioRepository;
	
	public Usuario save(Usuario usuario) throws RuntimeException{
		try {
			if(usuarioRepository.findByEmail(usuario.getEmail()) != null) {
				throw new EmailExistsException("Este e-mail já está cadastrado: " + usuario.getEmail());
			}
			
			//Criptografa a senha
			usuario.setCodigoSenha(Util.md5(usuario.getCodigoSenha()));

		}catch(NoSuchAlgorithmException e) {
			throw new CriptoExistsException("Ocorreu um erro na criptografia da senha.");
		}
		
		//Salva o usuario na base
		return usuarioRepository.save(usuario);
	}
	
	
	public Usuario validarLogin(String email, String codigoSenha) throws RuntimeException{
		
		Usuario usuario = null;
		String senhaCriptografada = null;
		
		try {
			senhaCriptografada = Util.md5(codigoSenha);
		} catch (NoSuchAlgorithmException e) {
			throw new CriptoExistsException("Ocorreu um erro na criptografia da senha.");
		}
		
		usuario = usuarioRepository.findByLogin(email, senhaCriptografada);
		
		if(usuario == null) {
			throw new LoginExistsException("E-mail e ou senha incorretos.");
		}
		
		return usuario;
	}
	
	
	public Usuario findById(Long id) {
		Optional<Usuario> obj = usuarioRepository.findById(id);
		return obj.get();
	}
	
	
	public Usuario update(Usuario novoUsuario) throws RuntimeException{

			Usuario usuario = usuarioRepository.getById(novoUsuario.getId());
			
			if(novoUsuario.getCodigoSenha() == null || novoUsuario.getCodigoSenha().isEmpty()) {

				atualizarDados(usuario, novoUsuario);
				
			}else {
				
				try {
					//Criptografa a senha
					novoUsuario.setCodigoSenha(Util.md5(novoUsuario.getCodigoSenha()));
				}catch(NoSuchAlgorithmException e) {
					throw new CriptoExistsException("Ocorreu um erro na criptografia da senha.");
				}
				
				atualizarDadosMaisSenha(usuario, novoUsuario);
				
			}
			
			return usuarioRepository.save(usuario);
	}
	
	
	public Usuario novaSenha(String email) throws RuntimeException{

		String senhaAleatoria = null;
		String hashNovaSenha = null;
		String novaSenha = null;
		
		//Pesquisa o usuario por e-mail
		Usuario usuario = usuarioRepository.findByEmail(email);

		if(usuario==null) {
			throw new EmailNotExistsException("Este e-mail não está cadastrado: " + email);
		}

		//Gerar senha aleatoria
		senhaAleatoria = Util.gerarSenhaAleatoria();

		try {
			//Gerar hash da senha aleatoria
			hashNovaSenha =  Util.md5(senhaAleatoria);
		}catch(NoSuchAlgorithmException e) {
			throw new CriptoExistsException("Ocorreu um erro na criptografia da senha.");
		}

		//Gerar nova senha para o usuario com 12 caracteres
		novaSenha = hashNovaSenha.substring(0, 12);

		
		//Define nova senha para o usuario
		usuario.setCodigoSenha(novaSenha);
		
		return usuario;
	}


	private void atualizarDados(Usuario usuario, Usuario novoUsuario) {
		usuario.setNome(novoUsuario.getNome());
		usuario.setSobrenome(novoUsuario.getSobrenome());
	}

	private void atualizarDadosMaisSenha(Usuario usuario, Usuario novoUsuario) {
		usuario.setNome(novoUsuario.getNome());
		usuario.setSobrenome(novoUsuario.getSobrenome());
		usuario.setCodigoSenha(novoUsuario.getCodigoSenha());
	}

}
