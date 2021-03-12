package com.example.SOTIS.service.impl;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SOTIS.model.apartment.Apartment;
import com.example.SOTIS.model.apartment.ApartmentForSale;
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
	
	
	public Set<Apartment> getAllActiveApartmentsForRent(){
		return apartmentRepository.getAllActiveApartmentsForRent();
	}
	
	public Set<Apartment> getAllActiveApartmentsForSale(){
		return apartmentRepository.getAllActiveApartmentsForSale();
	}

	// C:/Users/Dusan/Desktop/Images
	public Boolean writeImagesNewFolder(Long apartmentId, Set<String> nizNizovaBajta) {
		
		// ako iz nekog razloga ne postoji folder Images, pravimo ga
		if (!new File("C:/Users/Dusan/Desktop/Images").exists()) {
		    File folderImages = new File("C:/Users/Dusan/Desktop/Images");
		    Boolean b = folderImages.mkdir();
		}
		
	    //Creating a File object
	    File folder1 = new File("C:/Users/Dusan/Desktop/Images/apartment-" + apartmentId.toString());
	    //Creating the directory
	    boolean bool = folder1.mkdir();
		
	    int brojac = 0;
		for(String nizBajtova: nizNizovaBajta) {

			BufferedWriter writer;
			try {
				writer = new BufferedWriter(new FileWriter("C:/Users/Dusan/Desktop/Images/apartment-" + apartmentId.toString() + "/images-" + brojac));
				writer.write(nizBajtova);
				writer.close();

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			brojac ++;
			
		}
		return bool;
	}
	
	


}
