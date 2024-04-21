package com.jcmm.capStrong.service;

import java.util.List;

import com.jcmm.capStrong.model.Grade;
import com.jcmm.capStrong.repository.GradeRepository;
import com.jcmm.capStrong.exception.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GradeServiceImpl implements GradeService {

    @Autowired
    GradeRepository grade;

    @Override
    public List<Grade> getAllGrades() {
        return grade.findAll();
    }

    @Override
    public Grade getGradeById(int id) {
        if(grade.findById(id).isPresent()){
            return grade.findById(id).get();
        } else {
            throw new GradeNotFound();
        }
    }

    @Override
    public Grade createGrade(Grade newGrade) {
        return grade.save(newGrade);
    }

    @Override
    public Grade updateGradeById(int id, Grade updatedGrade) {
                
            Grade currentGrade = getGradeById(id);

            if (updatedGrade.getGradeId() != null) {
                currentGrade.setGradeId(updatedGrade.getGradeId());
            }
            if (updatedGrade.getStudentId() != null) {
                currentGrade.setStudentId(updatedGrade.getStudentId());
            }
            if (updatedGrade.getGrade() != null) {
                currentGrade.setGrade(updatedGrade.getGrade());
            }
            if (updatedGrade.getAssignmentId() != null) {
                currentGrade.setAssignmentId(updatedGrade.getAssignmentId());
            }
            return grade.save(currentGrade);
    }

    @Override
    public void deleteGradeById(int id) {
        grade.deleteById(id);
    }

     @Override
    public Grade getGradeByGradeId(int gradeId) {
        if(grade.findById(gradeId).isPresent()){
            return grade.findById(gradeId).get();
        } else {
            throw new StudentNotFound();
        }
    }

}
