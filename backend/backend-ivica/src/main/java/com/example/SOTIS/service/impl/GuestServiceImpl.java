package com.example.SOTIS.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.SOTIS.dto.AgencyRequest;
import com.example.SOTIS.dto.GuestRequest;
import com.example.SOTIS.model.Agency;
import com.example.SOTIS.model.Authority;
import com.example.SOTIS.model.Guest;
import com.example.SOTIS.repository.AgencyRepository;
import com.example.SOTIS.repository.GuestRepository;
import com.example.SOTIS.service.AuthorityService;
import com.example.SOTIS.service.GuestService;

@Service
public class GuestServiceImpl implements GuestService{

	@Autowired
	private AgencyRepository agencyRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private AuthorityService authService;
	
	@Autowired
	private GuestRepository guestRepostitory;

	@Override
	public Guest findById(Long id) {
		Guest guest = guestRepostitory.findById(id).orElseGet(null);
		return guest;
	}

	@Override
	public Guest findByUsername(String username) {
		Guest guest = guestRepostitory.findByUsername(username);
		return guest;
	}

	@Override
	public List<Guest> findAll() {
		List<Guest> guests = guestRepostitory.findAll();
		return guests;
	}

	@Override
	public Guest save(GuestRequest guestRequest) {
		Guest a = new Guest();
		a.setUsername(guestRequest.getUsername());
		
		// hesiram sifru pre postavljanja u bazu
		a.setPassword(passwordEncoder.encode(guestRequest.getPassword()));
		a.setEmail(guestRequest.getEmail());

		a.setFirstName(guestRequest.getFirstName());
		a.setLastName(guestRequest.getLastName());
		
		a.setEnabled(true);
		
		// Dodavanje random verifikacionog koda
		int verificationCode = (int)(Math.random()*900000)+100000;
		a.setVerificationCode(verificationCode);
		
		// Postavljam polje enabled na false, sve dok se ne validira email
		a.setValidated(false);
		
		List<Authority> auth = authService.findByname("ROLE_GUEST");
		a.setAuthorities(auth);
		
		a = this.guestRepostitory.save(a);
		
		return a;
	}
}
