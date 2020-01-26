package com.gear.proex.service;

import com.gear.proex.model.FootExam;
import org.springframework.stereotype.Service;

import java.util.List;

public interface FootExamService {

    List<FootExam> getAll();

    FootExam save(FootExam footExam);



    void delete(Long id);
}
