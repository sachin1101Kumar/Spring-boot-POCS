package com.registration.loginapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.registration.loginapp.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
