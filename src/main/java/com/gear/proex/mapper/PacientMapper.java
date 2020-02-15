package com.gear.proex.mapper;

import com.gear.proex.DTO.PacientDTO;
import com.gear.proex.model.Pacient;
import org.modelmapper.ModelMapper;

import java.util.List;

public class PacientMapper implements GenericMapper<Pacient,PacientDTO> {

    @Override
    public  PacientDTO convertToDTO(Pacient pacient) {
        return new ModelMapper().map(pacient, PacientDTO.class);
    }

    @Override
    public Pacient convertToEntity(PacientDTO dto) {
        Pacient pacient = new Pacient();
        if(dto.getId() != null) pacient.setId(dto.getId());
        pacient.setName(dto.getName());
        pacient.setAge(dto.getAge());
        pacient.setCpf(dto.getCpf());
        return pacient;
    }
}
