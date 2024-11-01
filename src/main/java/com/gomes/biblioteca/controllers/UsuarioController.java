package com.gomes.biblioteca.controllers;

import com.gomes.biblioteca.model.User;
import com.gomes.biblioteca.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/registro")
    public ResponseEntity<User> registrarUsuario(@RequestBody User user) {
    User novoUser = usuarioService.registrarUsuario(user);
    return ResponseEntity.ok(novoUser);
    }

}
