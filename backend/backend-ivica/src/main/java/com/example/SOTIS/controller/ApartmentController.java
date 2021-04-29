package com.example.SOTIS.controller;

import java.security.Principal;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.SOTIS.dto.SlikeSetByte;
import com.example.SOTIS.model.User;
import com.example.SOTIS.model.apartment.Apartment;
import com.example.SOTIS.service.UserService;
import com.example.SOTIS.service.impl.ApartmentServiceImpl;

@RestController
@RequestMapping(value = "/apartment", produces = MediaType.APPLICATION_JSON_VALUE)
public class ApartmentController {

	@Autowired
	private ApartmentServiceImpl apartmentService;
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/activeAll")
	public ResponseEntity<Set<Apartment>> getAllActiveApartments() {
		Set<Apartment> apartments = apartmentService.getAllActiveApartments();
		return new ResponseEntity<>(apartments, HttpStatus.OK);
	}
	
	@GetMapping("/activeForRent")
	public ResponseEntity<Set<Apartment>> getAllActiveApartmentsForRent() {
		Set<Apartment> apartments = apartmentService.getAllActiveApartmentsForRent();
		return new ResponseEntity<>(apartments, HttpStatus.OK);
	}
	
	@GetMapping("/activeForSale")
	public ResponseEntity<Set<Apartment>> getAllActiveApartmentsForSale() {
		Set<Apartment> apartments = apartmentService.getAllActiveApartmentsForSale();
		return new ResponseEntity<>(apartments, HttpStatus.OK);
	}
	
	
	@GetMapping("/images/{apartmentId}")
	public ResponseEntity<SlikeSetByte> getApartmentImages(@PathVariable Long apartmentId) {

		SlikeSetByte slike = apartmentService.getApartmentImages(apartmentId);
		return new ResponseEntity<>(slike, HttpStatus.OK);
	}
	
	
}
