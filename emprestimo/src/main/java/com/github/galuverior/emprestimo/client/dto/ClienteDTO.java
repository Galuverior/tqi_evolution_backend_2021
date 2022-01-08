package com.github.galuverior.emprestimo.client.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class ClienteDTO {

    private Long id;

    private String nome;

    private String email;

    private String cpf;

    private String rg;

    private String senha;

    private Long renda;

    private String endereco;

}
