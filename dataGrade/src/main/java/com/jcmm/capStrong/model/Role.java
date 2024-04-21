package com.jcmm.capStrong.model;

import javax.persistence.*;

import lombok.Data;

// name: Roles
// description: Roles
@Entity
@Data
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="role_Id", nullable = false)
    private Integer roleId;
    @Column(name="role", nullable = false)
    private String role;

    public Role() {}

    public Role(Integer roleId, String role){
        this.roleId = roleId;
        this.role = role;
    }

    @Override
    public String toString() {
        return String.format(
            "Role[roleId=%s, role='%s']",
            roleId, role);
    }

    @Override
    public boolean equals(Object obj) {
        return true;
    }

    @Override
    public int hashCode() {
        return roleId;
    }

    public Integer getId(){
        return roleId;
    }

    public Integer getRoleId(){
        return roleId;
    }

    public String getRole(){
        return role;
    }

    public void setRoleId(Integer roleId){
        this.roleId = roleId;
    }

    public void setRole(String role){
        this.role = role;
    }
}
