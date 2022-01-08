package com.github.galuverior.emprestimo.client.repository;

import com.github.galuverior.emprestimo.client.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    @Query("SELECT c FROM Cliente c WHERE c.email like :email ")
    Cliente getClienteByEmail(@Param("email") String email);

    @Query("SELECT TRUE AS LOGIN FROM Cliente WHERE email like :email and senha like :senha")
    Boolean validaCredenciaisCliente(@Param("email") String email, @Param("senha") String senha);
}
