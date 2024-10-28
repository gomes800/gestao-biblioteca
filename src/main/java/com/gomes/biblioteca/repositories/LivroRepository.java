package com.gomes.biblioteca.repositories;

import com.gomes.biblioteca.entities.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<Livro, Long> {
}
