package com.github.galuverior.emprestimo.emprestimo.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class EmprestimoMinimalDTO {

    private Long id;

    private Long valor;

    private Long qntdParcelas;

}
