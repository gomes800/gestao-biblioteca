package com.gomes.biblioteca.entities;

public class Administrador extends Usuario{

    private String cargo;

    public Administrador(long id, String nome, String email, String senha, String tipo, String cargo) {
        super(id, nome, email, senha, tipo);
        this.cargo = cargo;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
}
