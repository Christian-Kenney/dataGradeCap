package com.jcmm.capStrong.service;

import com.jcmm.capStrong.model.Assignment;

import java.util.List;

public interface AssignmentService {
    List<Assignment> getAllAssignments ();
    Assignment getAssignmentById (int id);
    Assignment createAssignment (Assignment newAssignment);
    Assignment updateAssignmentById (int id, Assignment updatedAssignment);
    void deleteAssignmentById (int id);
    Assignment getAssignmentByAssignmentId(int assignmentId);
}
