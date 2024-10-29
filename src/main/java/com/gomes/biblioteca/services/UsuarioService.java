package com.gomes.biblioteca.services;

import com.gomes.biblioteca.model.Usuario;
import com.gomes.biblioteca.model.enums.TipoUsuario;
import com.gomes.biblioteca.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario registrarUsuario(Usuario usuario) {
        usuario.setTipo(TipoUsuario.CLIENTE);
        return usuarioRepository.save(usuario);
    }

    public Usuario buscarPorUsuario(String nomeUsuario) {
        return usuarioRepository.findByNomeUsuario(nomeUsuario).orElse(null);
    }
}
