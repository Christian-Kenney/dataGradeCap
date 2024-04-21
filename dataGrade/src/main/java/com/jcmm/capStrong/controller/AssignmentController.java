package com.jcmm.capStrong.controller;

import com.jcmm.capStrong.model.Assignment;
import com.jcmm.capStrong.service.AssignmentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
public class AssignmentController {
    @Autowired
    private AssignmentService assignments;

    @GetMapping("/assignment")
    @ResponseStatus(HttpStatus.OK)
    public List<Assignment> getAllassignments() {
        return assignments.getAllAssignments();
    }

    @PostMapping(value = "/assignment",
            consumes = "application/json",
            produces = "application/json")
    public ResponseEntity createAssignment(@RequestBody Assignment newassignment) {
        Assignment assignment = assignments.createAssignment(newassignment);
        URI location = null;

        try {
            location = new URI(String.format("/assignment/%d", assignment.getAssignmentId()));
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setLocation(location);
        return new ResponseEntity<>(assignment, responseHeaders, HttpStatus.CREATED);
    }

    @GetMapping("/assignment/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Assignment getassignmentById(@PathVariable("id") int assignmentId) {
        return assignments.getAssignmentByAssignmentId(assignmentId);
    }

    @PatchMapping("/assignment/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Assignment updateassignmentById(@PathVariable("id") int id, @RequestBody Assignment updatedassignment) {
        return assignments.updateAssignmentById(id, updatedassignment);
    }

    @DeleteMapping("/assignment/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteassignmentById(@PathVariable("id") int id) {
        assignments.deleteAssignmentById(id);
    }
}
