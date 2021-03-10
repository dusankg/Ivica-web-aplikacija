package com.example.SOTIS.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.SOTIS.model.apartment.Apartment;

public interface ApartmentRepository extends JpaRepository<Apartment, Long> {

	// vracam sve aktivne apartmane
	@Query("SELECT a FROM Apartment a WHERE a.active = true")
	Set<Apartment> getAllActiveApartments();
	
	
}
