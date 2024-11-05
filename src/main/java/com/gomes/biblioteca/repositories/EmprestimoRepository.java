package com.gomes.biblioteca.repositories;

import com.gomes.biblioteca.model.Emprestimo;
import com.gomes.biblioteca.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmprestimoRepository extends JpaRepository<Emprestimo, Long> {

}
