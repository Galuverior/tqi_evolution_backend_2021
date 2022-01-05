package com.github.galuverior.emprestimo.client.service;

import com.github.galuverior.emprestimo.client.entity.Cliente;
import com.github.galuverior.emprestimo.client.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Optional<Cliente> getClienteById(Long id) {

        return clienteRepository.findById(id);
    }
}
