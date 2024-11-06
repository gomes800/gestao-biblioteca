package com.gomes.biblioteca.services;

import com.gomes.biblioteca.model.Livro;
import com.gomes.biblioteca.repositories.LivroRepository;
import com.gomes.biblioteca.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
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

    public Livro update(Long id, Livro obj) {
        try {
            Livro entity = repository.getReferenceById(id);
            updateData(entity, obj);
            return repository.save(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }

    private void updateData(Livro entity, Livro obj) {
        entity.setTitulo(obj.getTitulo());
        entity.setAutor(obj.getAutor());
        entity.setIsbn(obj.getIsbn());
        entity.setDisponibilidade(obj.getDisponibilidade());
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public Livro salvarLivro(Livro livro) {
        return repository.save(livro);
    }
}
