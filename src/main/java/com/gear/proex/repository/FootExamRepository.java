package com.gear.proex.repository;

import com.gear.proex.model.FootExam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FootExamRepository extends JpaRepository<FootExam, Long> {
    List<FootExam> findByPacientId(@Param("pacientId") Long pacientId);

}
