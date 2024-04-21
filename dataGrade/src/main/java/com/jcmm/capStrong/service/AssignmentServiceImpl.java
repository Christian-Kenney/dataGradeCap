package com.jcmm.capStrong.service;

import java.util.List;

import com.jcmm.capStrong.model.Assignment;
import com.jcmm.capStrong.repository.AssignmentRepository;
import com.jcmm.capStrong.exception.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AssignmentServiceImpl implements AssignmentService {

    @Autowired
    AssignmentRepository assignments;

    @Override
    public List<Assignment> getAllAssignments() {
        return assignments.findAll();
    }

    @Override
    public Assignment getAssignmentById(int id) {
        if(assignments.findById(id).isPresent()){
            return assignments.findById(id).get();
        } else {
            throw new AssignmentNotFound();
        }
    }

    @Override
    public Assignment createAssignment(Assignment newAssignment) {
        return assignments.save(newAssignment);
    }

    @Override
    public Assignment updateAssignmentById(int id, Assignment updatedAssignment) {
                
            Assignment currentAssignment = getAssignmentById(id);

            if (updatedAssignment.getAssignmentId() != null) {
                currentAssignment.setAssignmentId(updatedAssignment.getAssignmentId());
            }
            if (updatedAssignment.getClassId() != null) {
                currentAssignment.setClassId(updatedAssignment.getClassId());
            }
            if (updatedAssignment.getName() != null) {
                currentAssignment.setName(updatedAssignment.getName());
            }
            return assignments.save(currentAssignment);
    }

    @Override
    public void deleteAssignmentById(int id) {
        assignments.deleteById(id);
    }

     @Override
    public Assignment getAssignmentByAssignmentId(int assignmentId) {
        if(assignments.findById(assignmentId).isPresent()){
            return assignments.findById(assignmentId).get();
        } else {
            throw new StudentNotFound();
        }
    }

}
