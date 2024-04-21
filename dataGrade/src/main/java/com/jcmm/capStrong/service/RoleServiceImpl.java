package com.jcmm.capStrong.service;

import java.util.List;

import com.jcmm.capStrong.model.Role;
import com.jcmm.capStrong.repository.RoleRepository;
import com.jcmm.capStrong.exception.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleRepository Roles;

    @Override
    public List<Role> getAllRoles() {
        return Roles.findAll();
    }

    @Override
    public Role getRoleById(int id) {
        if(Roles.findById(id).isPresent()){
            return Roles.findById(id).get();
        } else {
            throw new RoleNotFound();
        }
    }

    @Override
    public Role createRole(Role newRole) {
        return Roles.save(newRole);
    }

    @Override
    public Role updateRoleById(int id, Role updatedRole) {
                
            Role currentRole = getRoleById(id);

            if (updatedRole.getRoleId() != null) {
                currentRole.setRoleId(updatedRole.getRoleId());
            }
            if (updatedRole.getRole() != null) {
                currentRole.setRole(updatedRole.getRole());
            }
            return Roles.save(currentRole);
    }

    @Override
    public void deleteRoleById(int id) {
        Roles.deleteById(id);
    }

     @Override
    public Role getRoleByRoleId(int roleId) {
        if(Roles.findById(roleId).isPresent()){
            return Roles.findById(roleId).get();
        } else {
            throw new StudentNotFound();
        }
    }

}
