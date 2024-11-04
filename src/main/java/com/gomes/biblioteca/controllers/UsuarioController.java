package com.gomes.biblioteca.controllers;

import com.gomes.biblioteca.model.Usuario;
import com.gomes.biblioteca.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @GetMapping
    public ResponseEntity<List<Usuario>> findAll() {
        List<Usuario> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Usuario> findById(@PathVariable Long id) {
        Usuario obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping("/registro")
    public ResponseEntity<Usuario> registrarUsuario(@RequestBody Usuario usuario) {
    Usuario novoUsuario = service.registrarUsuario(usuario);
    return ResponseEntity.ok(novoUsuario);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Usuario> update (@PathVariable Long id, @RequestBody Usuario obj) {
        obj = service.update(id, obj);
        return ResponseEntity.ok().body(obj);
    }

}
