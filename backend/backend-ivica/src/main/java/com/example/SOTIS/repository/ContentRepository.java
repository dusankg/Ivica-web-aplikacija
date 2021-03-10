package com.example.SOTIS.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.SOTIS.model.apartment.Content;

public interface ContentRepository extends JpaRepository<Content, Long> {

}
