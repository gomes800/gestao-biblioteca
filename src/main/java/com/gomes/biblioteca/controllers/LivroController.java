package com.gomes.biblioteca.controllers;

import com.gomes.biblioteca.entities.Livro;
import com.gomes.biblioteca.services.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/livros")
public class LivroController {

    @Autowired
    private LivroService livroService;

    @PostMapping("/adicionar")
    public ResponseEntity<Livro> adcionarLivro(@RequestBody Livro livro) {
        Livro novoLivro = livroService.adicionarLivro(livro);
        return new ResponseEntity<>(novoLivro, HttpStatus.CREATED);
    }

}
