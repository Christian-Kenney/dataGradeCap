package com.jcmm.capStrong.controller;

import com.jcmm.capStrong.model.Grade;
import com.jcmm.capStrong.service.GradeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
public class GradeController {
    @Autowired
    private GradeService grades;

    @GetMapping("/grade")
    @ResponseStatus(HttpStatus.OK)
    public List<Grade> getAllGrades() {
        return grades.getAllGrades();
    }

    @PostMapping(value = "/grade",
            consumes = "application/json",
            produces = "application/json")
    public ResponseEntity createGrade(@RequestBody Grade newGrade) {
        Grade Grade = grades.createGrade(newGrade);
        URI location = null;

        try {
            location = new URI(String.format("/grade/%d", Grade.getGradeId()));
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setLocation(location);
        return new ResponseEntity<>(Grade, responseHeaders, HttpStatus.CREATED);
    }

    @GetMapping("/grade/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Grade getGradeById(@PathVariable("id") int GradeId) {
        return grades.getGradeByGradeId(GradeId);
    }

    @PatchMapping("/grade/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Grade updateGradeById(@PathVariable("id") int id, @RequestBody Grade updatedGrade) {
        return grades.updateGradeById(id, updatedGrade);
    }

    @DeleteMapping("/grade/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteGradeById(@PathVariable("id") int id) {
        grades.deleteGradeById(id);
    }
}
