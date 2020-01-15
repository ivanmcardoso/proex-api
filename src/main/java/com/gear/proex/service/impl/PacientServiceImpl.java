package com.gear.proex.service.impl;

import com.gear.proex.model.Pacient;
import com.gear.proex.repository.PacientRepository;
import com.gear.proex.service.PacientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PacientServiceImpl implements PacientService {

    @Autowired
    private PacientRepository pacientRepository;

    @Override
    public List<Pacient> getAll() {
        return pacientRepository.findAll();
    }



    @Override
    public Optional<Pacient> findByCpf(String cpf) {
        return Optional.ofNullable(pacientRepository.findByCpf(cpf));
    }

    @Override
    public Optional<Pacient> findById(Long id) {
        return pacientRepository.findById(id);
    }

    @Override
    public Pacient save(Pacient pacient) {
        return pacientRepository.save(pacient);
    }

    @Override
    public void delete(Long id) {
        pacientRepository.deleteById(id);
    }
}
