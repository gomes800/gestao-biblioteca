package com.gomes.biblioteca.controllers;

import com.gomes.biblioteca.model.Livro;
import com.gomes.biblioteca.services.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/livros")
public class LivroController {

    @Autowired
    private LivroService service;

    @GetMapping
    public List<Livro> listaLivros() {
        return service.listaLivros();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Livro> buscarLivroPorId(@PathVariable Long id) {
        Optional<Livro> livro = service.buscarLivroPorID(id);
        return livro.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/titulo/{titulo}")
    public ResponseEntity<Livro> buscarLivroPorTitulo(@PathVariable String titulo) {
        Optional<Livro> livro = service.buscarLivroPorTitulo(titulo);
        return livro.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/adicionar")
    public ResponseEntity<Livro> adcionarLivro(@RequestBody Livro livro) {
        Livro novoLivro = service.adicionarLivro(livro);
        return new ResponseEntity<>(novoLivro, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Livro> atualizarLivro(@PathVariable Long id, @RequestBody Livro livro) {
        Livro livroAtualizado = service.update(id, livro);
        return ResponseEntity.ok(livroAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarLivro(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
