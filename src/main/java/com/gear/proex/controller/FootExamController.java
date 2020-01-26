package com.gear.proex.controller;

import com.gear.proex.model.FootExam;
import com.gear.proex.model.Pacient;
import com.gear.proex.service.FootExamService;
import com.gear.proex.service.PacientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/footExam")
@CrossOrigin("*")
public class FootExamController {

    @Autowired
    FootExamService footExamService;

    @Autowired
    PacientService pacientService;

    @PostMapping
    public ResponseEntity<FootExam> register( Long userId){
        FootExam footExam = new FootExam();

        try{
            Optional<Pacient> pacient = pacientService.findById(userId);
            footExam.setPacient(pacient.get());
            footExamService.save(footExam);
        } catch (Exception ex){
            return ResponseEntity.badRequest().body(footExam);
        }

        return ResponseEntity.ok(footExam);
    }

    @GetMapping
    public List<FootExam> getAll(){
        return footExamService.getAll();
    }
}
