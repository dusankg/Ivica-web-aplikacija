package com.example.SOTIS.model.apartment;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class ApartmentForRent extends Apartment {

	@Column
	private Float price_per_night;
	
	@Column
	private String check_in_time;
	
	@Column
	private String check_out_time;
	
}
