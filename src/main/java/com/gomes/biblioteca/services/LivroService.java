package com.gomes.biblioteca.services;

import com.gomes.biblioteca.model.Livro;
import com.gomes.biblioteca.repositories.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivroService {

    @Autowired
    private LivroRepository repository;

    public Livro adicionarLivro(Livro livro) {
        return repository.save(livro);
    }

    public List<Livro> listaLivros() {
        return repository.findAll();
    }

    public Optional<Livro> buscarLivroPorID(Long id) {
        return repository.findById(id);
    }

    public Optional<Livro> buscarLivroPorTitulo(String titulo) {
        return repository.findByTitulo(titulo);
    }

    public Livro atualizarLivro(Long id, Livro livroatualizado) {
        livroatualizado.setId(id);;
        return repository.save(livroatualizado);
    }

    public void deletarLivro(Long id) {
        repository.deleteById(id);
    }

    public Livro salvarLivro(Livro livro) {
        return repository.save(livro);
    }
}
