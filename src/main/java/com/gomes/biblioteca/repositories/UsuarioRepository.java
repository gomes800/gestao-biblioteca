package com.gomes.biblioteca.repositories;

import com.gomes.biblioteca.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<User, Long> {

    Optional<User> findByNomeUsuario(String nomeUsuario);
}
