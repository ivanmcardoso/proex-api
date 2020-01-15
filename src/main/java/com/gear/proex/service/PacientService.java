package com.gear.proex.service;

import com.gear.proex.model.Pacient;

import java.util.List;
import java.util.Optional;

public interface PacientService {

    List<Pacient> getAll();

    Optional<Pacient> findByCpf(String cpf);

    Optional<Pacient> findById(Long id);

    Pacient save(Pacient pacient);

    void delete(Long id);
}
