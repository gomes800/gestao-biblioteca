package com.gomes.biblioteca.model;

import com.gomes.biblioteca.model.enums.TipoUsuario;

public class Cliente extends Usuario {

    public Cliente(long id, String nome, String email, String senha, TipoUsuario tipo) {
        super(id, nome, email, senha, tipo);
    }
}
