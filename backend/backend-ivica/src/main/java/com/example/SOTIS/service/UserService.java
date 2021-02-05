package com.example.SOTIS.service;

import java.util.List;

import com.example.SOTIS.model.User;
import com.example.SOTIS.model.UserRequest;



public interface UserService {
    User findById(Long id);
    User findByUsername(String username);
    List<User> findAll ();
	User save(UserRequest userRequest);
}
