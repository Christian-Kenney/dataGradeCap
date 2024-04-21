package com.jcmm.capStrong.controller;

import com.jcmm.capStrong.model.Class;
import com.jcmm.capStrong.service.ClassService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
public class ClassController {
    @Autowired
    private ClassService classes;

    @GetMapping("/class")
    @ResponseStatus(HttpStatus.OK)
    public List<Class> getAllClasses() {
        return classes.getAllClasses();
    }

    @PostMapping(value = "/class",
            consumes = "application/json",
            produces = "application/json")
    public ResponseEntity createClass(@RequestBody Class newClass) {
        Class Class = classes.createClass(newClass);
        URI location = null;

        try {
            location = new URI(String.format("/class/%d", Class.getClassId()));
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setLocation(location);
        return new ResponseEntity<>(Class, responseHeaders, HttpStatus.CREATED);
    }

    @GetMapping("/class/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Class getClassById(@PathVariable("id") int ClassId) {
        return classes.getClassById(ClassId);
    }

    @PatchMapping("/class/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Class updateClassById(@PathVariable("id") int id, @RequestBody Class updatedClass) {
        return classes.updateClassById(id, updatedClass);
    }

    @DeleteMapping("/class/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteClassById(@PathVariable("id") int id) {
        classes.deleteClassById(id);
    }
}
