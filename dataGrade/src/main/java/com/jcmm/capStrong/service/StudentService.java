package com.jcmm.capStrong.service;

import com.jcmm.capStrong.model.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudents ();
    Student getStudentById (int id);
    Student createStudent (Student newStudent);
    Student updateStudentById (int id, Student updatedStudent);
    void deleteStudentById (int id);
    Student getStudentByUserId(int userId);
}
