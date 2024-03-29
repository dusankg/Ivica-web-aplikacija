package com.example.SOTIS.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.SOTIS.model.User;
import com.example.SOTIS.model.apartment.ApartmentForSale;
import com.example.SOTIS.service.UserService;
import com.example.SOTIS.service.impl.ApartmentForSaleServiceImpl;

@RestController
@RequestMapping(value = "/apartmentForSale", produces = MediaType.APPLICATION_JSON_VALUE)
public class ApartmentForSaleController {

	@Autowired
	private ApartmentForSaleServiceImpl apartmentForSaleService;
	
	@Autowired
	private UserService userService;
	
	@PostMapping
	@PreAuthorize("hasRole('AGENCY')")
	public ResponseEntity<String> createApartmentForSale(@RequestBody ApartmentForSale apartmentForSale, Principal user){

		User loggedInUser = userService.findByUsername(user.getName());
		
		Long id = apartmentForSaleService.addApartmentForSale(apartmentForSale);
		if (id == -1l) {
			return new ResponseEntity<>("Apartman nije ispravno dodat", HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<>(loggedInUser.getUsername(), HttpStatus.OK);
		}
	}
}
