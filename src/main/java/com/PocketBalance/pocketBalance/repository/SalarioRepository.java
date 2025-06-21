package com.pocketbalance.pocketbalance.repository;

import com.pocketbalance.pocketbalance.domain.Salario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalarioRepository extends JpaRepository<Salario, Long> {
}
