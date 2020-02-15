package com.gear.proex.service;

import com.gear.proex.model.FootExam;
import org.springframework.stereotype.Service;

import java.util.List;

public interface FootExamService extends GenericService<FootExam, Long> {

    List<FootExam> findByPatientId(Long id);

}
