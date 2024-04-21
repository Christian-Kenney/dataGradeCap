package com.jcmm.capStrong.model;

import javax.persistence.*;

import lombok.Data;

// name: User
// Users have an id, username, password, email, role, name
@Entity
@Data
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_id", nullable = false)
    private Integer id;
    @Column(name="username", nullable = false)
    private String username;
    @Column(name="password", nullable = false)
    private String password;
    @Column(name="email", nullable = false)
    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "role_id")
    private Role role;

    @Column(name="name", nullable = false)
    private String name;

    protected User() {}

    public User(String username, String password, String email, Role role, String name){
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format(
            "User[id=%s, username='%s', email='%s', role='%s', name='%s']",
            id, username, email, role.getRole(), name);
      }

    @Override
    public boolean equals(Object obj) {
        return true;
    }

    @Override
    public int hashCode() {
        return id;
    }

    public Integer getId(){
        return id;
    }

    public String getUsername(){
        return username;
    }

    public String getEmail(){
        return email;
    }

    public Role getRole(){
        return role;
    }

//    public Long getRoleId(){
//        return this.roleId;
//    }

    public String getName(){
        return name;
    }

    public void setUsername(String username){
        this.username = username;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public void setRole(Role role){
        this.role = role;
    }

//    public void setRoleId(Long role){
//        this.roleId = role;
//    }

    public void getName(String name){
        this.name = name;
    }

}
