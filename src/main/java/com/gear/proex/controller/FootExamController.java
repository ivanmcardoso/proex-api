package com.gear.proex.controller;

import com.gear.proex.model.FootExam;
import com.gear.proex.model.Pacient;
import com.gear.proex.service.FootExamService;
import com.gear.proex.service.PacientService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/footExam")
@CrossOrigin("*")
public class FootExamController {

    @Autowired
    FootExamService footExamService;

    @Autowired
    PacientService pacientService;

    @PostMapping
    @ApiOperation("register new foot exam")
    public ResponseEntity<FootExam> register(@RequestBody Long userId){
        FootExam footExam = new FootExam();

        try{
            Pacient pacient = pacientService.get(userId);
            footExam.setPacient(pacient);
            footExamService.add(footExam);
        } catch (Exception ex){
            return ResponseEntity.badRequest().body(footExam);
        }

        return ResponseEntity.ok(footExam);
    }

    @DeleteMapping
    @ApiOperation("delete foot exam by id")
    public void delete(Long id){
        footExamService.removeById(id);
    }

    @GetMapping("/{id}")
    @ApiOperation("get foot exam by id")
    public List<FootExam> findByPatientId(@PathVariable Long id){
        return footExamService.findByPatientId(id);
    }
}
