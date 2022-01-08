package com.github.galuverior.emprestimo.emprestimo.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@Data
public class EmprestimoDetailDTO {

    private Long id;

    private Long valor;

    private Long qntdParcelas;

    private LocalDate dataPrimeiraParcela;

    private String email;

    private Long renda;

}
