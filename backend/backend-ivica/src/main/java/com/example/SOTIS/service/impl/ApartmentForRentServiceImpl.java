package com.example.SOTIS.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SOTIS.model.apartment.ApartmentForRent;
import com.example.SOTIS.model.apartment.Location;
import com.example.SOTIS.repository.ApartmentForRentRepository;
import com.example.SOTIS.repository.ApartmentRepository;
import com.example.SOTIS.repository.LocationRepository;
import com.example.SOTIS.repository.TypeRepository;

@Service
public class ApartmentForRentServiceImpl {
	@Autowired
	private ApartmentRepository apartmentRepository;

	@Autowired
	private ApartmentForRentRepository apartmentForRentRepository;

	@Autowired
	private LocationRepository locationRepository;

	@Autowired
	private TypeRepository typeRepository;
	
	
	public Long addApartmentForRent(ApartmentForRent apartmentForRent) {
		
		Location l = apartmentForRent.getLocation();
		
		if (apartmentForRent.getLocation().getId() != null) {
			if (locationRepository.existsById(apartmentForRent.getLocation().getId())) {
				l = locationRepository.getOne( apartmentForRent.getLocation().getId());
			} else {
				l.setId(null);
			}
		}
		
		apartmentForRent.setLocation(l);

		
		apartmentForRent.setForSale(false);
		apartmentForRent.setActive(true);
		apartmentForRent = apartmentForRentRepository.save(apartmentForRent);
		if(apartmentForRent == null) {
			return -1l;
		}
		return apartmentForRent.getId();
	}
}
