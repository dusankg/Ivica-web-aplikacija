package com.example.SOTIS.model.apartment;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.example.SOTIS.model.Agency;

@Entity
public class Apartment {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    // polja povezana preko baze
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Type type;
    
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Content> contents;
    
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Image> images;
    
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Location location;
    
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Agency agency; //kasnije promeniti ako ubacimo da moze da bude vlasnik i obican korisnik, odn neka druga rola
    
    // samostalna polja
    @Column
    private int roomsNumber;
    
    @Column
    private Integer guestsNumber;
    
    @Column
    private Boolean active;
    
    @Column
    private Boolean for_sale; // ako je za prodaju true, ako je za iznajmljivanje onda false

    
    
    
	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}



	public Set<Content> getContents() {
		return contents;
	}

	public void setContents(Set<Content> contents) {
		this.contents = contents;
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

	public Agency getAgency() {
		return agency;
	}

	public void setAgency(Agency agency) {
		this.agency = agency;
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

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public Boolean getFor_sale() {
		return for_sale;
	}

	public void setFor_sale(Boolean for_sale) {
		this.for_sale = for_sale;
	}
    
      
    
    
    
    
    
    
    
}
