package com.example.SOTIS.dto;

import java.util.Set;

import com.example.SOTIS.model.apartment.Image;
import com.example.SOTIS.model.apartment.Location;
import com.example.SOTIS.model.apartment.Type;

public class apartmentInfoDTO {

	private Long id;
	
	private Type type;
	
	private Set<Image> images;
	
	private Location location;
	
	private int roomsNumber;
	
	private Integer guestsNumber;
	
	private Boolean for_sale;

	
	
	// GET and SET methods
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public Set<Image> getImages() {
		return images;
	}

	public void setImages(Set<Image> images) {
		this.images = images;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public int getRoomsNumber() {
		return roomsNumber;
	}

	public void setRoomsNumber(int roomsNumber) {
		this.roomsNumber = roomsNumber;
	}

	public Integer getGuestsNumber() {
		return guestsNumber;
	}

	public void setGuestsNumber(Integer guestsNumber) {
		this.guestsNumber = guestsNumber;
	}

	public Boolean getFor_sale() {
		return for_sale;
	}

	public void setFor_sale(Boolean for_sale) {
		this.for_sale = for_sale;
	}
	
	
	
}
