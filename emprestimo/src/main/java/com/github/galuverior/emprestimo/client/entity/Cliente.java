package com.github.galuverior.emprestimo.client.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name = "Cliente")
@Table(name = "cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "email")
    private String email;

    @Column(name = "cpf")
    private Long cpf;

    @Column(name = "rg")
    private Long rg;

    @Column(name = "senha")
    private Long senha;

    @Column(name = "renda")
    private Long renda;

    @Column(name = "endereco")
    private String endereco;

}
