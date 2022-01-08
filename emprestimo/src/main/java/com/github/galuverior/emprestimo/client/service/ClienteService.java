package com.github.galuverior.emprestimo.client.service;

import com.github.galuverior.emprestimo.client.dto.ClienteDTO;
import com.github.galuverior.emprestimo.client.entity.Cliente;
import com.github.galuverior.emprestimo.client.repository.ClienteRepository;
import com.github.galuverior.emprestimo.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Optional<Cliente> getClienteById(Long id) {

        return clienteRepository.findById(id);
    }

    public Cliente cadastroCliente(ClienteDTO clienteDTO) {
        try {
            StringUtils.isValid(clienteDTO.getCpf());
            Cliente cliente = new Cliente(clienteDTO.getId(), clienteDTO.getNome(), clienteDTO.getEmail(),
                    clienteDTO.getCpf(), clienteDTO.getRg(), clienteDTO.getSenha(), clienteDTO.getRenda(),
                    clienteDTO.getEndereco());

            return clienteRepository.save(cliente);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Boolean validaCredenciaisCliente(String email, String senha) {
        return Objects.nonNull(clienteRepository.validaCredenciaisCliente(email, senha) ? true : false);
    }
}
