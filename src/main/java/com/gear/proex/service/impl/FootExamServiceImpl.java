package com.gear.proex.service.impl;

import com.gear.proex.model.FootExam;
import com.gear.proex.repository.FootExamRepository;
import com.gear.proex.service.FootExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FootExamServiceImpl implements FootExamService {

    @Autowired
    private FootExamRepository footExamRepository;

    @Override
    public List<FootExam> getAll() {
        return footExamRepository.findAll();
    }

    @Override
    public FootExam save(FootExam footExam) {
        return footExamRepository.save(footExam);
    }

    @Override
    public void delete(Long id) {
        footExamRepository.deleteById(id);
    }
}
