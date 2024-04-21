package com.jcmm.capStrong.repository;

import com.jcmm.capStrong.model.Role;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {

  Role findByRoleId(Integer roleId);
}