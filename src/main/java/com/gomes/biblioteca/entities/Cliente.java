package com.gomes.biblioteca.entities;

public class Cliente extends Usuario{

    public Cliente(long id, String nome, String email, String senha, String tipo) {
        super(id, nome, email, senha, tipo);
    }
}
