package com.github.galuverior.emprestimo.emprestimo.repository;

import com.github.galuverior.emprestimo.emprestimo.dto.EmprestimoDetailDTO;
import com.github.galuverior.emprestimo.emprestimo.dto.EmprestimoMinimalDTO;
import com.github.galuverior.emprestimo.emprestimo.entity.Emprestimo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmprestimoRepository extends JpaRepository<Emprestimo, Long> {

    @Query("SELECT e FROM Emprestimo e WHERE e.cliente.id = :clienteId")
    List<Emprestimo> getEmprestimosByCliente(@Param("clienteId")Long clienteId);

    @Query("SELECT e FROM Emprestimo e WHERE e.id = :id")
    Emprestimo getEmprestimosById(@Param("id") Long id);

}
