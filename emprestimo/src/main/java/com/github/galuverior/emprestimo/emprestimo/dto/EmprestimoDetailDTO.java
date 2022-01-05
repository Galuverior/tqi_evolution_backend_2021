package com.github.galuverior.emprestimo.emprestimo.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@Data
public class EmprestimoDetailDTO {

    private Long id;

    private Long valor;

    private Long qntdParcelas;

    private Date dataPrimeiraParcela;

    private String email;

    private Long renda;

}
