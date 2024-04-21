package com.jcmm.capStrong.repository;

import java.util.List;

import com.jcmm.capStrong.model.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

  List<User> findByName(String name);
  public User findByEmail(String email);
}