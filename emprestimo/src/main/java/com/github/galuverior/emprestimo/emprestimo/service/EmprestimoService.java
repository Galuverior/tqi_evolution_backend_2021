package com.github.galuverior.emprestimo.emprestimo.service;

import com.github.galuverior.emprestimo.client.entity.Cliente;
import com.github.galuverior.emprestimo.client.repository.ClienteRepository;
import com.github.galuverior.emprestimo.emprestimo.dto.EmprestimoDetailDTO;
import com.github.galuverior.emprestimo.emprestimo.dto.EmprestimoMinimalDTO;
import com.github.galuverior.emprestimo.emprestimo.entity.Emprestimo;
import com.github.galuverior.emprestimo.emprestimo.repository.EmprestimoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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
        return getEmprestimoDetailDTO(emprestimoRepository.getById(id));
    }

    public EmprestimoMinimalDTO getEmprestimoMinimalById(Long id) {
        return getEmprestimoMinimalDTO(emprestimoRepository.getById(id));
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
        Cliente cliente = clienteRepository.getClienteByEmail(emprestimoDetailDTO.getEmail());
        Emprestimo emprestimo = new Emprestimo(4L, emprestimoDetailDTO.getValor(), emprestimoDetailDTO.getDataPrimeiraParcela(),
                emprestimoDetailDTO.getQntdParcelas(), cliente);

        return emprestimoRepository.save(emprestimo);
    }
}
