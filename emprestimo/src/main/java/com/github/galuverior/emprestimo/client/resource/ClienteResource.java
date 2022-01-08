package com.github.galuverior.emprestimo.client.resource;

import com.github.galuverior.emprestimo.client.dto.ClienteDTO;
import com.github.galuverior.emprestimo.client.entity.Cliente;
import com.github.galuverior.emprestimo.client.service.ClienteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("cliente")
public class ClienteResource {

    private final ClienteService clienteService;

    public ClienteResource(ClienteService clienteService) {

        this.clienteService = clienteService;
    }

    @PostMapping("/cadastro")
    public ResponseEntity<Cliente> cadastroCliente(@RequestBody ClienteDTO clienteDTO) {

        Cliente cliente = clienteService.cadastroCliente(clienteDTO);

        return Objects.nonNull(cliente) ? ResponseEntity.ok().body(cliente) : ResponseEntity.badRequest().build();

    }

    @GetMapping("/{id}")
    public ResponseEntity <Cliente> consultaCliente(@PathVariable Long id) {
        Optional<Cliente> optional = clienteService.getClienteById(id);

        if (optional.isPresent()) {
            return ResponseEntity.ok().body(optional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
