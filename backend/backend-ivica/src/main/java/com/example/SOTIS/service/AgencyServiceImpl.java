package com.example.SOTIS.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.SOTIS.dto.AgencyRequest;
import com.example.SOTIS.model.Agency;
import com.example.SOTIS.model.Authority;
import com.example.SOTIS.model.User;
import com.example.SOTIS.repository.AgencyRepository;

@Service
public class AgencyServiceImpl implements AgencyService {

	@Autowired
	private AgencyRepository agencyRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private AuthorityService authService;
	
	@Override
	public Agency findById(Long id) {
		Agency agency = agencyRepository.findById(id).orElseGet(null);
		return agency;
	}

	@Override
	public Agency findByUsername(String username) {
		Agency agency = agencyRepository.findByUsername(username);
		return agency;
	}

	@Override
	public List<Agency> findAll() {
		List<Agency> agencies = agencyRepository.findAll();
		return agencies;
	}

	@Override
	public Agency save(AgencyRequest agencyRequest) {
		Agency a = new Agency();
		a.setUsername(agencyRequest.getUsername());
		
		// hesiram sifru pre postavljanja u bazu
		a.setPassword(passwordEncoder.encode(agencyRequest.getPassword()));
		a.setEmail(agencyRequest.getEmail());
		a.setName(agencyRequest.getName());
		a.setPib(agencyRequest.getPib());
		a.setEnabled(true);
		
		// Dodavanje random verifikacionog koda
		int verificationCode = (int)(Math.random()*900000)+100000;
		a.setVerificationCode(verificationCode);
		
		// Postavljam polje enabled na false, sve dok se ne validira email
		a.setValidated(false);
		
		List<Authority> auth = authService.findByname("ROLE_AGENCY");
		a.setAuthorities(auth);
		
		a = this.agencyRepository.save(a);
		
		return a;
	}

}
