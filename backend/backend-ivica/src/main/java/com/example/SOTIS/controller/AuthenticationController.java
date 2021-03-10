package com.example.SOTIS.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.SOTIS.dto.AgencyRequest;
import com.example.SOTIS.dto.GuestRequest;
import com.example.SOTIS.dto.VerificateAcountDTO;
import com.example.SOTIS.exception.ResourceConflictException;
import com.example.SOTIS.model.Agency;
import com.example.SOTIS.model.Guest;
import com.example.SOTIS.model.User;
import com.example.SOTIS.model.UserRequest;
import com.example.SOTIS.model.UserTokenState;
import com.example.SOTIS.repository.AgencyRepository;
import com.example.SOTIS.repository.UserRepository;
import com.example.SOTIS.secutiry.TokenUtils;
import com.example.SOTIS.secutiry.auth.JwtAuthenticationRequest;
import com.example.SOTIS.service.AgencyService;
import com.example.SOTIS.service.EmailService;
import com.example.SOTIS.service.GuestService;
import com.example.SOTIS.service.UserService;
import com.example.SOTIS.service.impl.CustomUserDetailsService;



//Kontroler zaduzen za autentifikaciju korisnika
@RestController
@RequestMapping(value = "/auth", produces = MediaType.APPLICATION_JSON_VALUE)
public class AuthenticationController {

	@Autowired
	private TokenUtils tokenUtils;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private CustomUserDetailsService userDetailsService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private AgencyService agencyService;
	
	@Autowired
	private EmailService emailService;

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private GuestService guestService;
	
	// Prvi endpoint koji pogadja korisnik kada se loguje.
	// Tada zna samo svoje korisnicko ime i lozinku i to prosledjuje na backend.
	@PostMapping("/login")
	public ResponseEntity<UserTokenState> createAuthenticationToken(@RequestBody JwtAuthenticationRequest authenticationRequest,
			HttpServletResponse response) {

		// 
		Authentication authentication = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(),
						authenticationRequest.getPassword()));

		// Ubaci korisnika u trenutni security kontekst
		SecurityContextHolder.getContext().setAuthentication(authentication);

		// Kreiraj token za tog korisnika
		User user = (User) authentication.getPrincipal();
		
		if(user.isValidated() == false) {
			ResponseEntity.badRequest();
		}
		String jwt = tokenUtils.generateToken(user.getUsername());
		int expiresIn = tokenUtils.getExpiredIn();

		return ResponseEntity.ok(new UserTokenState(jwt, expiresIn));
	}

	// Endpoint za registraciju novog korisnika
	@PostMapping("/signup")
	public ResponseEntity<User> addUser(@RequestBody GuestRequest userRequest, UriComponentsBuilder ucBuilder) throws MailException, InterruptedException {

		User existUser = this.userService.findByUsername(userRequest.getUsername());
		if (existUser != null) {
			throw new ResourceConflictException(userRequest.getId(), "Username already exists");
		}

		Guest user = this.guestService.save(userRequest);
		
		// Dodatno postavljam email adresu i vrednosti polja "enabled" na False kako bismo mogli da ga verifikujemo kasnije
		user.setEmail(userRequest.getEmail());
		
		user.setEnabled(true);
		user.setValidated(false);
		
		// Dodavanje random verifikacionog koda
		int verificationCode = (int)(Math.random()*9000)+1000;
		user.setVerificationCode(verificationCode);
		
		userRepository.save(user);
		emailService.sendVerificationCode(user);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/api/user/{userId}").buildAndExpand(user.getId()).toUri());
		return new ResponseEntity<>(user, HttpStatus.CREATED);
	}
	
	// Endpoint za registraciju novog korisnika
	@PostMapping("/signupAgency")
	public ResponseEntity<Agency> addAgency(@RequestBody AgencyRequest agencyRequest, UriComponentsBuilder ucBuilder) throws MailException, InterruptedException {

		User existUser = this.userService.findByUsername(agencyRequest.getUsername());
		if (existUser != null) {
			throw new ResourceConflictException(agencyRequest.getId(), "Username already exists");
		}

		// za detalje funcije pogledati implementaciju agencyService-a
		Agency agency = this.agencyService.save(agencyRequest);
		
		// TODO email servis, slanje validacionog mail-a
		emailService.sendVerificationCodeAgency(agency);
		
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/api/user/{userId}").buildAndExpand(agency.getId()).toUri());
		return new ResponseEntity<>(agency, HttpStatus.CREATED);
	}
	
	// Endpoint za validaciju i korisnika i agencije
	@PostMapping("/verificate")
	public ResponseEntity<User> verificateUserAccount(@RequestBody VerificateAcountDTO verificateAccount) throws MailException, InterruptedException {

		User existUser = this.userService.findByUsername(verificateAccount.getUsername());
		if (existUser == null) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
		
		Authentication authentication = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(verificateAccount.getUsername(),
						verificateAccount.getPassword()));
		User user = (User) authentication.getPrincipal();
		
		
		//User user = this.userService.findByUsername(verificateAccount.getUsername());
		
		if (user.getVerificationCode() != verificateAccount.getValidationCode()) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
		user.setValidated(true);
		user.setEnabled(true);
		
		userRepository.save(user);

		return new ResponseEntity<>(user, HttpStatus.ACCEPTED);
	}


	// U slucaju isteka vazenja JWT tokena, endpoint koji se poziva da se token osvezi
	@PostMapping(value = "/refresh")
	public ResponseEntity<UserTokenState> refreshAuthenticationToken(HttpServletRequest request) {

		String token = tokenUtils.getToken(request);
		String username = this.tokenUtils.getUsernameFromToken(token);
		User user = (User) this.userDetailsService.loadUserByUsername(username);

		if (this.tokenUtils.canTokenBeRefreshed(token, user.getLastPasswordResetDate())) {
			String refreshedToken = tokenUtils.refreshToken(token);
			int expiresIn = tokenUtils.getExpiredIn();

			return ResponseEntity.ok(new UserTokenState(refreshedToken, expiresIn));
		} else {
			UserTokenState userTokenState = new UserTokenState();
			return ResponseEntity.badRequest().body(userTokenState);
		}
	}

	@RequestMapping(value = "/change-password", method = RequestMethod.POST)
	@PreAuthorize("hasRole('USER')")
	public ResponseEntity<?> changePassword(@RequestBody PasswordChanger passwordChanger) {
		userDetailsService.changePassword(passwordChanger.oldPassword, passwordChanger.newPassword);

		Map<String, String> result = new HashMap<>();
		result.put("result", "success");
		return ResponseEntity.accepted().body(result);
	}

	static class PasswordChanger {
		public String oldPassword;
		public String newPassword;
	}
}