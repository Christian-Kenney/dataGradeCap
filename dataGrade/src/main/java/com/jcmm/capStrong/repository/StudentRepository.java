package com.jcmm.capStrong.repository;

import com.jcmm.capStrong.model.Student;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {

  Student findByUserId(Integer userId);
}