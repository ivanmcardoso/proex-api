package com.gear.proex.controller;

import com.gear.proex.DTO.PacientDTO;
import com.gear.proex.mapper.PacientMapper;
import com.gear.proex.model.Pacient;
import com.gear.proex.service.PacientService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/pacients")
@CrossOrigin(origins = "*")
public class PacientController {

    @Autowired
    PacientService pacientService;

    private final PacientMapper pacientMapper = new PacientMapper();

    @DeleteMapping
    @ApiOperation("delete patient by id")
    public void deleteById(Long id){
        pacientService.removeById(id);
    }

    @PostMapping
    @ApiOperation("register new patient")
    public ResponseEntity<PacientDTO>  register(@Valid @RequestBody PacientDTO pacientDTO){
        try{
            Pacient pacient = pacientMapper.convertToEntity(pacientDTO);
            pacientService.add(pacient);
        } catch (Exception ex){
            return ResponseEntity.badRequest().body(pacientDTO);
        }
        return ResponseEntity.ok(pacientDTO);
    }

    @PutMapping
    @ApiOperation("update a patient")
    ResponseEntity<PacientDTO> update(@Valid @RequestBody PacientDTO pacientDTO){
        try{
            Pacient pacient = pacientMapper.convertToEntity(pacientDTO);
            pacientService.update(pacient);
        } catch (Exception ex){
            return ResponseEntity.badRequest().body(pacientDTO);
        }
        return ResponseEntity.ok(pacientDTO);
    }

    @GetMapping
    @ApiOperation("list all patient")
    public List<PacientDTO> getAll(){
        return pacientMapper.convertToListDTO(pacientService.getAll());
    }

    @GetMapping("/{id}")
    @ApiOperation("get patient by id")
    public Pacient findByID(Long id){
        return pacientService.get(id);
    }

    @GetMapping("/findByCpf")
    @ApiOperation("get patient by CPF")
    public Optional<Pacient> findByCpf(String cpf){
        return pacientService.findByCpf(cpf);
    }
}
