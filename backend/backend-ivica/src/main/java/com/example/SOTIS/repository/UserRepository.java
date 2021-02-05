package com.example.SOTIS.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.SOTIS.model.User;


public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername( String username );
}

