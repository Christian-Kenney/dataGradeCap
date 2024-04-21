package com.jcmm.capStrong.repository;

import com.jcmm.capStrong.model.Grade;

import org.springframework.data.jpa.repository.JpaRepository;

public interface GradeRepository extends JpaRepository<Grade, Integer> {

  Grade findByGradeId(Integer gradeId);
}