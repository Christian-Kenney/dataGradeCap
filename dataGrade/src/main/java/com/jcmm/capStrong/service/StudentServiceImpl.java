package com.jcmm.capStrong.service;

import java.util.List;

import com.jcmm.capStrong.model.Student;
import com.jcmm.capStrong.repository.StudentRepository;
import com.jcmm.capStrong.exception.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepository Students;

    @Override
    public List<Student> getAllStudents() {
        return Students.findAll();
    }

    @Override
    public Student getStudentById(int id) {
        if(Students.findById(id).isPresent()){
            return Students.findById(id).get();
        } else {
            throw new StudentNotFound();
        }
    }

    @Override
    public Student createStudent(Student newStudent) {
        return Students.save(newStudent);
    }

    @Override
    public Student updateStudentById(int id, Student updatedStudent) {
                
            Student currentStudent = getStudentById(id);

            if (updatedStudent.getUserId() != null) {
                currentStudent.setUserId(updatedStudent.getUserId());
            }
            if (updatedStudent.getClassId() != null) {
                currentStudent.setClassId(updatedStudent.getClassId());
            }
            return Students.save(currentStudent);
    }

    @Override
    public void deleteStudentById(int id) {
        Students.deleteById(id);
    }

    @Override
    public Student getStudentByUserId(int userId) {
        if(Students.findById(userId).isPresent()){
            return Students.findById(userId).get();
        } else {
            throw new StudentNotFound();
        }
    }

}
