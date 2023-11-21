package com.isabela.lombok.projetoLombok.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.isabela.lombok.projetoLombok.entities.Usuario;

public interface UsuarioRepositorio extends JpaRepository<Usuario, Long>  {



	
}