package com.jcmm.capStrong.repository;

import com.jcmm.capStrong.model.Class;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassRepository extends JpaRepository<Class, Integer> {

  Class findByClassId(Integer userId);
}