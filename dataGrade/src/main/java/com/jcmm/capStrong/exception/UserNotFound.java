package com.jcmm.capStrong.exception;

public class UserNotFound extends RuntimeException {
    public UserNotFound(){
        super(String.format("User not found"));
    }
}
