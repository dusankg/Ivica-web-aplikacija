package com.example.SOTIS.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.SOTIS.model.Guest;

public interface GuestRepository extends JpaRepository<Guest, Long>{

	Guest findByUsername( String username );
}
