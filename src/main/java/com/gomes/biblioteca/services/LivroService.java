package com.gomes.biblioteca.services;

import com.gomes.biblioteca.model.Livro;
import com.gomes.biblioteca.repositories.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;

    public Livro adicionarLivro(Livro livro) {
        return livroRepository.save(livro);
    }

    public List<Livro> listaLivros() {
        return livroRepository.findAll();
    }

    public Optional<Livro> buscarLivroPorID(Long id) {
        return livroRepository.findById(id);
    }

    public Optional<Livro> buscarLivroPorTitulo(String titulo) {
        return livroRepository.findByTitulo(titulo);
    }

    public Livro atualizarLivro(Long id, Livro livroatualizado) {
        livroatualizado.setId(id);;
        return livroRepository.save(livroatualizado);
    }

    public void deletarLivro(Long id) {
        livroRepository.deleteById(id);
    }

    public Livro salvarLivro(Livro livro) {
        return livroRepository.save(livro);
    }
}
