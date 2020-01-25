package com.gear.proex.controller;

import com.gear.proex.DTO.PacientDTO;
import com.gear.proex.model.Pacient;
import com.gear.proex.service.PacientService;
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

    @PostMapping
    public ResponseEntity<PacientDTO>  register(@Valid @RequestBody PacientDTO pacientDTO){

        try{
            Pacient pacient = convertTo(pacientDTO);
            pacientService.save(pacient);
        } catch (Exception ex){
            return ResponseEntity.badRequest().body(pacientDTO);
        }

        return ResponseEntity.ok(pacientDTO);
    }

    private Pacient convertTo(PacientDTO pacientDTO) {
        Pacient pacient = new Pacient();
        pacient.setName(pacientDTO.getName());
        pacient.setAge(pacientDTO.getAge());
        pacient.setCpf(pacientDTO.getCpf());
        return pacient;
    }

    @GetMapping
    public List<Pacient> getAll(){
        return pacientService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Pacient> findByID(Long id){
        return pacientService.findById(id);
    }

    @GetMapping("/findByCpf")
    public Optional<Pacient> findByCpf(String cpf){
        return pacientService.findByCpf(cpf);
    }
}
