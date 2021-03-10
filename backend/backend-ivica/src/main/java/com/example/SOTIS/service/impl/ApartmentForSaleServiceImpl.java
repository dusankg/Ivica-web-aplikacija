package com.example.SOTIS.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SOTIS.model.apartment.ApartmentForSale;
import com.example.SOTIS.repository.ApartmentForSaleRepository;
import com.example.SOTIS.repository.ApartmentRepository;
import com.example.SOTIS.repository.LocationRepository;
import com.example.SOTIS.repository.TypeRepository;

@Service
public class ApartmentForSaleServiceImpl {

	@Autowired
	private ApartmentRepository apartmentRepository;

	@Autowired
	private ApartmentForSaleRepository apartmentForSaleRepository;

	@Autowired
	private LocationRepository locationRepository;

	@Autowired
	private TypeRepository typeRepository;
	
	
	public Long addApartmentForSale(ApartmentForSale apartmentForSale) {
	
		apartmentForSale.setForSale(true);
		apartmentForSale.setActive(true);
		apartmentForSale = apartmentForSaleRepository.save(apartmentForSale);
		if(apartmentForSale == null) {
			return -1l;
		}
		return apartmentForSale.getId();
	}
}
