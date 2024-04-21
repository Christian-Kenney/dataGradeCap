package com.jcmm.capStrong.exception;

public class StudentNotFound extends RuntimeException {
    public StudentNotFound(){
        super(String.format("Student not found"));
    }
}
