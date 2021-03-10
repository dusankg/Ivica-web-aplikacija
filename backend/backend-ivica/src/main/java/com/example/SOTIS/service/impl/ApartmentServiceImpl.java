package com.example.SOTIS.service.impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SOTIS.model.apartment.Apartment;
import com.example.SOTIS.model.apartment.Type;
import com.example.SOTIS.repository.ApartmentRepository;
import com.example.SOTIS.repository.LocationRepository;
import com.example.SOTIS.repository.TypeRepository;

@Service
public class ApartmentServiceImpl {

	@Autowired
	private ApartmentRepository apartmentRepository;
	

	@Autowired
	private LocationRepository locationRepository;

	@Autowired
	private TypeRepository typeRepository;
	
	public Set<Apartment> getAllActiveApartments(){
		return apartmentRepository.getAllActiveApartments();
	}


}
