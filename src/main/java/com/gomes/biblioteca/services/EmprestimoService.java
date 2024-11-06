package com.gomes.biblioteca.services;

import com.gomes.biblioteca.model.Emprestimo;
import com.gomes.biblioteca.model.Livro;
import com.gomes.biblioteca.repositories.EmprestimoRepository;
import com.gomes.biblioteca.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmprestimoService {

    @Autowired
    private EmprestimoRepository repository;

    public Emprestimo adicionar(Emprestimo emprestimo) {
        return repository.save(emprestimo);
    }

    public List<Emprestimo> listaEmprestimos() {
        return repository.findAll();
    }

    public Optional<Emprestimo> buscarEmprestimoPorId(Long id) {
        return repository.findById(id);
    }

    public Emprestimo update(Long id, Emprestimo obj) {
        try {
            Emprestimo entity = repository.getReferenceById(id);
            updateData(entity, obj);
            return repository.save(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }

    private void updateData(Emprestimo entity, Emprestimo obj) {
        entity.setDataEmprestimo(obj.getDataEmprestimo());
        entity.setDataDevolucao(obj.getDataDevolucao());
        entity.setStatus(obj.getStatus());
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
