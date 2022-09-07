package com.example.aprendendospring;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Cliente {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    public Cliente() {}
    public Cliente(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    
}
