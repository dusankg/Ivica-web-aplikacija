package com.example.SOTIS.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.SOTIS.model.Agency;

public interface AgencyRepository extends JpaRepository<Agency, Long> {

	Agency findByUsername( String username );
}
