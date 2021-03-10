package com.example.SOTIS.model.apartment;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class ApartmentForSale extends Apartment {

    @Column
    private Float price;
    
    @Column
    private Boolean fixed_price;

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public Boolean getFixed_price() {
		return fixed_price;
	}

	public void setFixed_price(Boolean fixed_price) {
		this.fixed_price = fixed_price;
	}
    
    
    
    
}
