package com.example.SOTIS.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.SOTIS.model.apartment.Location;

public interface LocationRepository extends JpaRepository<Location, Long> {

}
