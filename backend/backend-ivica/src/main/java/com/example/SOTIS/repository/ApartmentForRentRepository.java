package com.example.SOTIS.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.SOTIS.model.apartment.ApartmentForRent;

public interface ApartmentForRentRepository extends JpaRepository<ApartmentForRent, Long> {

}
