package com.gomes.biblioteca.services;

import com.gomes.biblioteca.model.Emprestimo;
import com.gomes.biblioteca.model.EmprestimoRequest;
import com.gomes.biblioteca.model.Livro;
import com.gomes.biblioteca.model.Usuario;
import com.gomes.biblioteca.repositories.EmprestimoRepository;
import com.gomes.biblioteca.repositories.LivroRepository;
import com.gomes.biblioteca.repositories.UsuarioRepository;
import com.gomes.biblioteca.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class EmprestimoService {

    @Autowired
    private EmprestimoRepository emprestimoRepository;

    @Autowired
    private LivroRepository livroRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Emprestimo adicionar(EmprestimoRequest emprestimoRequest) {
        Livro livro = livroRepository.findById(emprestimoRequest.getLivroId())
                .orElseThrow(() -> new IllegalArgumentException("Livro não encontrado"));

        if (!livro.isDisponivel()) {
            throw new IllegalArgumentException("Livro já está emprestado.");
        }

        Usuario usuario = usuarioRepository.findById(emprestimoRequest.getUsuarioId())
                .orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado"));

        Emprestimo emprestimo = new Emprestimo();
        emprestimo.setLivro(livro);
        emprestimo.setUsuario(usuario);
        emprestimo.setDataEmprestimo(LocalDate.now());
        emprestimo.setStatus(false);
        livro.setDisponibilidade(false);

        livroRepository.save(livro);

        return emprestimoRepository.save(emprestimo);
    }

    public Emprestimo devolver(Long emprestimoId) {
        Emprestimo emprestimo = emprestimoRepository.findById(emprestimoId)
                .orElseThrow(() -> new ResourceNotFoundException("Empréstimo não encontrado."));

        if (emprestimo.getStatus()) {
            throw new IllegalArgumentException("Este empréstimo já foi devolvido.");
        }

        emprestimo.setDataDevolucao(LocalDate.now());
        emprestimo.setStatus(true);

        Livro livro = emprestimo.getLivro();
        livro.setDisponibilidade(true);

        livroRepository.save(livro);
        return emprestimoRepository.save(emprestimo);
    }

    public List<Emprestimo> listaEmprestimos() {
        return emprestimoRepository.findAll();
    }

    public Optional<Emprestimo> buscarEmprestimoPorId(Long id) {
        return emprestimoRepository.findById(id);
    }

    public Emprestimo update(Long id, Emprestimo obj) {
        try {
            Emprestimo entity = emprestimoRepository.getReferenceById(id);
            updateData(entity, obj);
            return emprestimoRepository.save(entity);
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
        emprestimoRepository.deleteById(id);
    }
}
