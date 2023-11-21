package com.isabela.lombok.projetoLombok.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isabela.lombok.projetoLombok.entities.Usuario;
import com.isabela.lombok.projetoLombok.repositories.UsuarioRepositorio;

@Service
public class UsuarioService {
	private final UsuarioRepositorio usuarioRepository;

	
	@Autowired
	public  UsuarioService (UsuarioRepositorio usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
		
	}

	public Usuario findUsuarioById(Long id) {
		Optional<Usuario> Usuario = usuarioRepository.findById(id);
		return Usuario.orElse(null);
	}

	public List<Usuario> findAllUsuario() {
		return usuarioRepository.findAll();
	}

	public Usuario insertUsuario(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}

	public Usuario updateUsuario(Long id, Usuario novoUsuario) {
		Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);
		if (usuarioOptional.isPresent()) {
			Usuario usuarioExistente = usuarioOptional.get();
			usuarioExistente.setNome(novoUsuario.getNome());
			usuarioExistente.setEmail(novoUsuario.getEmail());
			return usuarioRepository.save(usuarioExistente);
		} else {
			return null;
		}
	}

	public boolean deleteUsuario(Long id) {
		Optional<Usuario> usuarioExistente = usuarioRepository.findById(id);
		if (usuarioExistente.isPresent()) {
			usuarioRepository.deleteById(id);
			return true;
		} else {
			return false;
		}
	}
}