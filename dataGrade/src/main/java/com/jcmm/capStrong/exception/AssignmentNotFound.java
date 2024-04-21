package com.jcmm.capStrong.exception;

public class AssignmentNotFound extends RuntimeException {
    public AssignmentNotFound(){
        super(String.format("Assignment not found"));
    }
}
