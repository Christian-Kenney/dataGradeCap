package com.jcmm.capStrong.controller;

import com.jcmm.capStrong.model.Student;
import com.jcmm.capStrong.service.StudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
public class StudentController {
    @Autowired
    private StudentService student;

    @GetMapping("/student")
    @ResponseStatus(HttpStatus.OK)
    public List<Student> getAllstudent() {
        return student.getAllStudents();
    }

    @PostMapping(value = "/student",
            consumes = "application/json",
            produces = "application/json")
    public ResponseEntity createStudent(@RequestBody Student newStudent) {
        Student Student = student.createStudent(newStudent);
        URI location = null;

        try {
            location = new URI(String.format("/student/%d", Student.getUserId()));
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setLocation(location);
        return new ResponseEntity<>(Student, responseHeaders, HttpStatus.CREATED);
    }

    @GetMapping("/student/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Student getStudentByUserId(@PathVariable("id") int userId) {
        return student.getStudentByUserId(userId);
    }

    @PatchMapping("/student/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Student updateStudentById(@PathVariable("id") int id, @RequestBody Student updatedStudent) {
        return student.updateStudentById(id, updatedStudent);
    }

    @DeleteMapping("/student/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteStudentById(@PathVariable("id") int id) {
        student.deleteStudentById(id);
    }
}
