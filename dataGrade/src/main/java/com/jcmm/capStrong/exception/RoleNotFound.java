package com.jcmm.capStrong.exception;

public class RoleNotFound extends RuntimeException {
    public RoleNotFound(){
        super(String.format("Role not found"));
    }
}
