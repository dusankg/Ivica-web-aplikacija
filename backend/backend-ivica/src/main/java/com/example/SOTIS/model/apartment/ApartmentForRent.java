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

	public Float getPrice_per_night() {
		return price_per_night;
	}

	public void setPrice_per_night(Float price_per_night) {
		this.price_per_night = price_per_night;
	}

	public String getCheck_in_time() {
		return check_in_time;
	}

	public void setCheck_in_time(String check_in_time) {
		this.check_in_time = check_in_time;
	}

	public String getCheck_out_time() {
		return check_out_time;
	}

	public void setCheck_out_time(String check_out_time) {
		this.check_out_time = check_out_time;
	}
	
	
	
	
}
