package com.jcmm.capStrong.service;

import com.jcmm.capStrong.exception.*;
import com.jcmm.capStrong.model.User;
import com.jcmm.capStrong.repository.UserRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository users;

    @Transactional
    public String getRoleNameForUser(Integer userId) {
        User user = users.findById(userId).orElse(null);
        if (user != null && user.getRole() != null) {
            return user.getRole().getRole();
        } else {
            return null; // Handle case where user or role is not found
        }
    }

    @Override
    public List<User> getAllUsers() {
        return users.findAll();
    }

    @Override
    public User getUserById(int id) {
        if(users.findById(id).isPresent()){
            return users.findById(id).get();
        } else {
            throw new UserNotFound();
        }
    }

    @Override
    public User createUser(User newUser) {
        return users.save(newUser);
    }

    @Override
    public User updateUserById(int id, User updateUser){
        User currentUser = getUserById(id);

        if(updateUser.getUsername() != null){
            currentUser.setUsername(updateUser.getUsername());
        }
        if(updateUser.getEmail() != null){
            currentUser.setEmail(updateUser.getEmail());
        }
        if(updateUser.getRole() != null){
            currentUser.setRole(updateUser.getRole());
        }
        if(updateUser.getName() != null){
            currentUser.setName(updateUser.getName());
        }
        if(updateUser.getPassword() != null){
            currentUser.setPassword(updateUser.getPassword());
        }
    
        return users.save(currentUser);

    }

    @Override
    public void deleteUserById(int id) {
            users.deleteById(id);
    }

}
