package com.gear.proex.repository;

import com.gear.proex.model.Pacient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public interface PacientRepository extends JpaRepository<Pacient, Long>{
    Pacient findByCpf(String cpf);
}
