package com.avaliaft.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity(name = "Cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String nome;
    String telefone;
    Integer idade;

    public Cliente(){

    }

    public Cliente(Long id, String nome, String telefone, Integer idade) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.idade = idade;
    }
}
