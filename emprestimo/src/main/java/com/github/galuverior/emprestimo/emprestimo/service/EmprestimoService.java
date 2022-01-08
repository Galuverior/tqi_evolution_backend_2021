package com.github.galuverior.emprestimo.emprestimo.service;

import com.github.galuverior.emprestimo.client.entity.Cliente;
import com.github.galuverior.emprestimo.client.repository.ClienteRepository;
import com.github.galuverior.emprestimo.emprestimo.dto.EmprestimoDetailDTO;
import com.github.galuverior.emprestimo.emprestimo.dto.EmprestimoMinimalDTO;
import com.github.galuverior.emprestimo.emprestimo.entity.Emprestimo;
import com.github.galuverior.emprestimo.emprestimo.repository.EmprestimoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class EmprestimoService {

    @Autowired
    private EmprestimoRepository emprestimoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    public Optional<Emprestimo> getEmprestimoById(Long id) {
        return emprestimoRepository.findById(id);
    }

    public List<Emprestimo> getEmprestimosByCliente(Long clienteId) {
        return emprestimoRepository.getEmprestimosByCliente(clienteId);
    }

    public EmprestimoDetailDTO getEmprestimoDetailById(Long id) {

        Emprestimo emprestimo = emprestimoRepository.getEmprestimosById(id);

        return Objects.nonNull(emprestimo) ? getEmprestimoDetailDTO(emprestimo) : null;
    }

    public EmprestimoMinimalDTO getEmprestimoMinimalById(Long id) {

        Emprestimo emprestimo = emprestimoRepository.getEmprestimosById(id);

        return Objects.nonNull(emprestimo) ? getEmprestimoMinimalDTO(emprestimo) : null;
    }

    public EmprestimoDetailDTO getEmprestimoDetailDTO(Emprestimo emprestimo) {
        EmprestimoDetailDTO emprestimoDetailDTO = new EmprestimoDetailDTO();

        emprestimoDetailDTO.setId(emprestimo.getId());
        emprestimoDetailDTO.setEmail(emprestimo.getCliente().getEmail());
        emprestimoDetailDTO.setRenda(emprestimo.getCliente().getRenda());
        emprestimoDetailDTO.setValor(emprestimo.getValor());
        emprestimoDetailDTO.setQntdParcelas(emprestimo.getQntdParcela());
        emprestimoDetailDTO.setDataPrimeiraParcela(emprestimo.getDataParcela1());

        return emprestimoDetailDTO;
    }

    public EmprestimoMinimalDTO getEmprestimoMinimalDTO(Emprestimo emprestimo) {
        EmprestimoMinimalDTO emprestimoMinimalDTO = new EmprestimoMinimalDTO();

        emprestimoMinimalDTO.setId(emprestimo.getId());
        emprestimoMinimalDTO.setValor(emprestimo.getValor());
        emprestimoMinimalDTO.setQntdParcelas(emprestimo.getQntdParcela());

        return emprestimoMinimalDTO;
    }

    public Emprestimo cadastroEmprestimo(EmprestimoDetailDTO emprestimoDetailDTO) {

        Emprestimo emprestimo = new Emprestimo();

        if(ChronoUnit.DAYS.between(LocalDate.now(),emprestimoDetailDTO.getDataPrimeiraParcela())< 91 &&
            emprestimoDetailDTO.getQntdParcelas()< 61) {

            Cliente cliente = clienteRepository.getClienteByEmail(emprestimoDetailDTO.getEmail());

            emprestimo.setId(emprestimoDetailDTO.getId());
            emprestimo.setValor(emprestimoDetailDTO.getValor());
            emprestimo.setDataParcela1(emprestimoDetailDTO.getDataPrimeiraParcela());
            emprestimo.setQntdParcela(emprestimoDetailDTO.getQntdParcelas());
            emprestimo.setCliente(cliente);

            emprestimoRepository.save(emprestimo);
        } else {
            emprestimo = null;
        }

        return emprestimo;
    }
}
