package com.example.SOTIS.service;

import java.util.List;

import com.example.SOTIS.model.Authority;


public interface AuthorityService {
	List<Authority> findById(Long id);
	List<Authority> findByname(String name);
}
