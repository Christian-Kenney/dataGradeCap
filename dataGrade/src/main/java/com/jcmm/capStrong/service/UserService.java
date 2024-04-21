package com.jcmm.capStrong.service;

import com.jcmm.capStrong.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers ();
    User getUserById (int id);
    User createUser (User newUser);
    User updateUserById (int id, User updatedUser);
    void deleteUserById (int id);
}
