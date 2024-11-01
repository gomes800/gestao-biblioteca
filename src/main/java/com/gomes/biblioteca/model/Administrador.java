package com.gomes.biblioteca.model;

import com.gomes.biblioteca.model.enums.TipoUsuario;

public class Administrador extends User {

    private String cargo;

    public Administrador(long id, String nome, String email, String senha, TipoUsuario tipo, String cargo) {
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
