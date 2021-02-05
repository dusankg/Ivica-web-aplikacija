package com.example.SOTIS.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.SOTIS.model.Authority;


public interface AuthorityRepository extends JpaRepository<Authority, Long> {
	Authority findByName(String name);
}
