package com.example.SOTIS.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.SOTIS.model.apartment.Image;

public interface ImageRepository extends JpaRepository<Image, Long> {

	
}
