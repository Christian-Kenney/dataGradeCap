package com.jcmm.capStrong.service;

import com.jcmm.capStrong.model.Role;

import java.util.List;

public interface RoleService {
    List<Role> getAllRoles ();
    Role getRoleById (int id);
    Role createRole (Role newRole);
    Role updateRoleById (int id, Role updatedRole);
    void deleteRoleById (int id);
    Role getRoleByRoleId(int roleId);
}
