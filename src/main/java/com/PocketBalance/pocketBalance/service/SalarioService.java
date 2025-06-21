package com.pocketbalance.pocketbalance.service;

import com.pocketbalance.pocketbalance.domain.Salario;
import com.pocketbalance.pocketbalance.repository.SalarioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SalarioService {

    @Autowired
    private SalarioRepository salarioRepository;

    @Transactional(readOnly = true)
    public List<Salario> getSalarios() {
        return salarioRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Salario getSalario(Salario salario) {
        return salarioRepository.findById(salario.getId_transaccion()).orElse(null);
    }

    @Transactional
    public void save(Salario salario) {
        salarioRepository.save(salario);
    }

    @Transactional
    public boolean delete(Salario salario) {
        try {
            salarioRepository.delete(salario);
            salarioRepository.flush();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
