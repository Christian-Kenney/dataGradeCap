package com.jcmm.capStrong.repository;

import com.jcmm.capStrong.model.Assignment;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AssignmentRepository extends JpaRepository<Assignment, Integer> {

  Assignment findByAssignmentId(Integer assignmentId);
}