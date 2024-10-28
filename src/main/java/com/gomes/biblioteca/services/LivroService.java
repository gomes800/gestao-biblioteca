package com.gomes.biblioteca.services;

import com.gomes.biblioteca.entities.Livro;
import com.gomes.biblioteca.repositories.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;

    public Livro adicionarLivro(Livro livro) {
        return livroRepository.save(livro);
    }
}
