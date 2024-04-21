package com.jcmm.capStrong.controller;

import com.jcmm.capStrong.model.Role;
import com.jcmm.capStrong.service.RoleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
public class RoleController {
    @Autowired
    private RoleService roles;

    @GetMapping("/role")
    @ResponseStatus(HttpStatus.OK)
    public List<Role> getAllRoles() {
        return roles.getAllRoles();
    }

    @PostMapping(value = "/role",
            consumes = "application/json",
            produces = "application/json")
    public ResponseEntity createRole(@RequestBody Role newRole) {
        Role role = roles.createRole(newRole);
        URI location = null;

        try {
            location = new URI(String.format("/role/%d", role.getRoleId()));
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setLocation(location);
        return new ResponseEntity<>(role, responseHeaders, HttpStatus.CREATED);
    }

    @GetMapping("/role/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Role getRoleById(@PathVariable("id") int roleId) {
        return roles.getRoleByRoleId(roleId);
    }

    @PatchMapping("/role/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Role updateRoleById(@PathVariable("id") int id, @RequestBody Role updatedRole) {
        return roles.updateRoleById(id, updatedRole);
    }

    @DeleteMapping("/role/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteRoleById(@PathVariable("id") int id) {
        roles.deleteRoleById(id);
    }
}
