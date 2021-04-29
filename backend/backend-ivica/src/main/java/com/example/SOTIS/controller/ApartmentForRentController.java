package com.example.SOTIS.controller;

import java.security.Principal;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.SOTIS.dto.SlikeSetByte;
import com.example.SOTIS.model.Agency;
import com.example.SOTIS.model.User;
import com.example.SOTIS.model.apartment.ApartmentForRent;
import com.example.SOTIS.service.UserService;
import com.example.SOTIS.service.impl.ApartmentForRentServiceImpl;
import com.example.SOTIS.service.impl.ApartmentServiceImpl;

@RestController
@RequestMapping(value = "/apartmentForRent", produces = MediaType.APPLICATION_JSON_VALUE)
public class ApartmentForRentController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private ApartmentForRentServiceImpl apartmentForRentService;
	
	@Autowired
	private ApartmentServiceImpl apartmentService;
	
	@PostMapping
	@PreAuthorize("hasRole('AGENCY')")
	public ResponseEntity<String> createApartmentForSale(@RequestBody ApartmentForRent apartmentForRent, Principal user){

		//User loggedInUser = userService.findByUsername(user.getName());
		
		Agency agencija = (Agency) userService.findByUsername(user.getName());

		apartmentForRent.setAgency( agencija );
		
		System.out.println(agencija.getPib());
		
		Long id = apartmentForRentService.addApartmentForRent(apartmentForRent);
		if (id == -1l) {
			return new ResponseEntity<>("Apartman nije ispravno dodat", HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<>(id.toString(), HttpStatus.OK);
		}
	}
	
	@PostMapping(value = "/images/{apartmentId}")
	@PreAuthorize("hasRole('AGENCY')")
	public ResponseEntity<String> addImages(@PathVariable Long apartmentId, @RequestBody SlikeSetByte slike, Principal user){

		User loggedInUser = userService.findByUsername(user.getName());
		
		Boolean uspesno = apartmentService.writeImagesNewFolder(apartmentId, slike.getSlike());
		
		
		if (uspesno) {
			return new ResponseEntity<>("Apartman nije ispravno dodat", HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<>(loggedInUser.getUsername() + loggedInUser.getAuthorities().toString(), HttpStatus.OK);
		}
	}
	
	
}
