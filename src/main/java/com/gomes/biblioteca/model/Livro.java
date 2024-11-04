package com.gomes.biblioteca.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String titulo;
    private String autor;
    private String isbn;
    private boolean disponibilidade;

    public Livro(){
    }

    public Livro(long id, String titulo, String autor, String isbn, Boolean disponibilidade) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.disponibilidade = disponibilidade;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public boolean getDisponibilidade() {
        return disponibilidade;
    }

    public void setDisponibilidade(boolean disponibilidade) {
        this.disponibilidade = disponibilidade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Livro livro = (Livro) o;
        return id == livro.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Livro{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", isbn='" + isbn + '\'' +
                ", disponibilidade=" + disponibilidade +
                '}';
    }

    public boolean emprestar() {
        if (disponibilidade) {
            disponibilidade = false;
            System.out.println("Livro emprestado com sucesso.");
            return true;
        } else {
            System.out.println("Livro não disponível para empréstimo.");
            return false;
        }
    }

    public boolean devolver() {
        if (!disponibilidade) {
            disponibilidade = true;
            System.out.println("Livro devolvido com sucesso.");
            return true;
        } else {
            System.out.println("Este livro não estava emprestado.");
            return false;
        }
    }
}
