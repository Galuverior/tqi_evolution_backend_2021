package com.github.galuverior.emprestimo.emprestimo.resource;

import com.github.galuverior.emprestimo.emprestimo.dto.EmprestimoDetailDTO;
import com.github.galuverior.emprestimo.emprestimo.dto.EmprestimoMinimalDTO;
import com.github.galuverior.emprestimo.emprestimo.entity.Emprestimo;
import com.github.galuverior.emprestimo.emprestimo.service.EmprestimoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("emprestimo")
public class EmprestimoResource {

    private final EmprestimoService emprestimoService;

    public EmprestimoResource(EmprestimoService emprestimoService) {
        this.emprestimoService = emprestimoService;
    }

    @GetMapping("/{id}")
    public ResponseEntity <Emprestimo> emprestimoById(@PathVariable Long id) {
        Optional<Emprestimo> emprestimo = emprestimoService.getEmprestimoById(id);

        if (emprestimo.isPresent()) {
            return ResponseEntity.ok().body(emprestimo.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/detalhe/{id}")
    public ResponseEntity<EmprestimoDetailDTO> emprestimoDetailById(@PathVariable Long id) {
        EmprestimoDetailDTO emprestimoDetailDTO = emprestimoService.getEmprestimoDetailById(id);
        return (Objects.nonNull(emprestimoDetailDTO) ? ResponseEntity.ok().body(emprestimoDetailDTO) : ResponseEntity.notFound().build());
    }

    @GetMapping("/minimo/{id}")
    public ResponseEntity<EmprestimoMinimalDTO> emprestimoMinimalById(@PathVariable Long id) {
        EmprestimoMinimalDTO emprestimoMinimalDTO = emprestimoService.getEmprestimoMinimalById(id);
        return (Objects.nonNull(emprestimoMinimalDTO) ? ResponseEntity.ok().body(emprestimoMinimalDTO) : ResponseEntity.notFound().build());
    }

    @GetMapping("/cliente/{clienteId}")
    public ResponseEntity <List<Emprestimo>> emprestimosByCliente(@PathVariable Long clienteId) {
        List<Emprestimo> emprestimos = emprestimoService.getEmprestimosByCliente(clienteId);
        return ((Objects.nonNull(emprestimos) && !emprestimos.isEmpty()) ? ResponseEntity.ok().body(emprestimos) : ResponseEntity.notFound().build());
    }

    @PostMapping("/cadastro")
    public ResponseEntity<Emprestimo> cadastroEmprestimo(@RequestBody EmprestimoDetailDTO emprestimoDetailDTO) {
        Emprestimo emprestimo = emprestimoService.cadastroEmprestimo(emprestimoDetailDTO);
        return (Objects.nonNull(emprestimo)) ? ResponseEntity.ok().body(emprestimo) : ResponseEntity.badRequest().build();
    }

}
