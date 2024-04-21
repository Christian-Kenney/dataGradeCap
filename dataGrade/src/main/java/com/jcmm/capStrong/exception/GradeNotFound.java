package com.jcmm.capStrong.exception;

public class GradeNotFound extends RuntimeException {
    public GradeNotFound(){
        super(String.format("Grade not found"));
    }
}
