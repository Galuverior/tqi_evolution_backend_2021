package com.github.galuverior.emprestimo.emprestimo.entity;

import com.github.galuverior.emprestimo.client.entity.Cliente;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name = "Emprestimo")
@Table(name = "emprestimo")
public class Emprestimo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "valor")
    private Long valor;

    @Column(name = "data_parcela_1")
    private LocalDate dataParcela1;

    @Column(name = "qntd_parcela")
    private Long qntdParcela;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

}
