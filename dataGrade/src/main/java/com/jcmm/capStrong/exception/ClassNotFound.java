package com.jcmm.capStrong.exception;

public class ClassNotFound extends RuntimeException {
    public ClassNotFound(){
        super(String.format("Class not found"));
    }
}
