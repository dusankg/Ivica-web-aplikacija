package com.example.SOTIS.model.apartment;

import java.sql.Blob;
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

import org.hibernate.type.BlobType;

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
    private Integer roomsNumber;
    
    @Column
    private Integer guestsNumber;
    
    @Column
    private Boolean active;
    
    @Column
    private Boolean forSale; // ako je za prodaju true, ako je za iznajmljivanje onda false

    @Column
    private String description;
    
    @Column
    private String keyWords;
    
    @Column
    private String phone;
    
    @Column
    private String email;
    
    @Column
    private String title;
    
    @Column(name = "tumbnail", length = 300000)
    private String tumbnail;
    
    
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

	public Boolean getForSale() {
		return forSale;
	}

	public void setForSale(Boolean for_sale) {
		this.forSale = for_sale;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setRoomsNumber(Integer roomsNumber) {
		this.roomsNumber = roomsNumber;
	}

	public String getKeyWords() {
		return keyWords;
	}

	public void setKeyWords(String keyWords) {
		this.keyWords = keyWords;
	}

	public String getTumbnail() {
		return tumbnail;
	}

	public void setTumbnail(String tumbnail) {
		this.tumbnail = tumbnail;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	

    
	
    
    
    
    
    
    
    
}
