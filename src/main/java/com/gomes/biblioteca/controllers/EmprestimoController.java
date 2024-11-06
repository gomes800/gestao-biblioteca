package com.gomes.biblioteca.controllers;

import com.gomes.biblioteca.model.Emprestimo;
import com.gomes.biblioteca.model.Livro;
import com.gomes.biblioteca.services.EmprestimoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/emprestimos")
public class EmprestimoController {

    @Autowired
    private EmprestimoService service;

    @GetMapping
    public List<Emprestimo> listaEmprestimos() {
        return service.listaEmprestimos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Emprestimo> buscarEmprestimoPorId(@PathVariable Long id) {
        Optional<Emprestimo> emprestimo = service.buscarEmprestimoPorId(id);
        return emprestimo.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Emprestimo> update(@PathVariable Long id, @RequestBody Emprestimo emprestimo) {
        Emprestimo emprestimoAtualizado = service.update(id, emprestimo);
        return ResponseEntity.ok(emprestimoAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
