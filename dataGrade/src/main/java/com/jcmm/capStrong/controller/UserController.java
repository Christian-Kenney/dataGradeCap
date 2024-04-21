package com.jcmm.capStrong.controller;

import com.jcmm.capStrong.model.User;
import com.jcmm.capStrong.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService users;

    @GetMapping("/users")
    @ResponseStatus(HttpStatus.OK)
    public List<User> getAllUsers() {
        return users.getAllUsers();
    }

    @PostMapping(value = "/users")
    public ResponseEntity createUser(@RequestBody User newUser) {
        User user = users.createUser(newUser);
        URI location = null;
        try {
            location = new URI(String.format("/users/%d", user.getId()));
        } catch (URISyntaxException e) {
            throw new RuntimeException("Error creating (POST) new user");
        }
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setLocation(location);
        return new ResponseEntity<>(user, responseHeaders, HttpStatus.CREATED);
    }

    @GetMapping("/users/{id}")
    @ResponseStatus(HttpStatus.OK)
    public User getUserById(@PathVariable("id") int id) {
        return users.getUserById(id);
    }

    @PatchMapping("/users/{id}")
    @ResponseStatus(HttpStatus.OK)
    public User updateUserById(@PathVariable("id") int id, @RequestBody User updatedUser) {
        return users.updateUserById(id, updatedUser);
    }

    @DeleteMapping("/users/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUserById(@PathVariable("id") int id) {
        users.deleteUserById(id);
    }
}
