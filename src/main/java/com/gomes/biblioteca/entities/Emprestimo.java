package com.gomes.biblioteca.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public class Emprestimo {

    private long id;
    private LocalDateTime dataEmprestimo;
    private LocalDateTime dataDevolucao;
    private String status;
    private Usuario usuario;
    private Livro livro;

    public Emprestimo(long id, LocalDateTime dataEmprestimo, LocalDateTime dataDevolucao, String status, Usuario usuario, Livro livro) {
        this.id = id;
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucao = dataDevolucao;
        this.status = status;
        this.usuario = usuario;
        this.livro = livro;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDateTime getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(LocalDateTime dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public LocalDateTime getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(LocalDateTime dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Emprestimo that = (Emprestimo) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    public void criarEmprestimo() {
        livro.setDisponibilidade(false);
        status = "Emprestado";
        dataEmprestimo = LocalDateTime.now();
    }

    public void finalizarEmprestimo() {
        livro.setDisponibilidade(true);;
        status = "finalizado";
        dataDevolucao = LocalDateTime.now();
    }
}
