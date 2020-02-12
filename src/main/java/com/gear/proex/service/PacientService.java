package com.gear.proex.service;

import com.gear.proex.DTO.PacientDTO;
import com.gear.proex.model.Pacient;

import java.util.List;
import java.util.Optional;

public interface PacientService extends GenericService<Pacient, Long> {

    Optional<Pacient> findByCpf(String cpf);
}
