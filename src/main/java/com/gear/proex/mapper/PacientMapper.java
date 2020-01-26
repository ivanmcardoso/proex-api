package com.gear.proex.mapper;

import com.gear.proex.DTO.PacientDTO;
import com.gear.proex.model.Pacient;
import org.modelmapper.ModelMapper;

import java.util.List;

public class PacientMapper {

    public  PacientDTO convertToDTO(Pacient pacient) {
       return new ModelMapper().map(pacient, PacientDTO.class);
    }
}
