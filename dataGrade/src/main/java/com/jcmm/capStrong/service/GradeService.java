package com.jcmm.capStrong.service;

import com.jcmm.capStrong.model.Grade;

import java.util.List;

public interface GradeService {
    List<Grade> getAllGrades ();
    Grade getGradeById (int id);
    Grade createGrade (Grade newGrade);
    Grade updateGradeById (int id, Grade updatedGrade);
    void deleteGradeById (int id);
    Grade getGradeByGradeId(int gradeId);
}
