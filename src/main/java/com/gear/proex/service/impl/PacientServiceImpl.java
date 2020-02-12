package com.gear.proex.service.impl;

import com.gear.proex.DTO.PacientDTO;
import com.gear.proex.mapper.PacientMapper;
import com.gear.proex.model.Pacient;
import com.gear.proex.repository.PacientRepository;
import com.gear.proex.service.PacientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springfox.documentation.swagger2.mappers.ModelMapper;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PacientServiceImpl extends GenericServiceImpl<Pacient, Long> implements PacientService {

    @Autowired
    private PacientRepository pacientRepository;

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
