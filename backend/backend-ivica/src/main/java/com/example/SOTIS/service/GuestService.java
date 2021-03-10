package com.example.SOTIS.service;

import java.util.List;

import com.example.SOTIS.dto.GuestRequest;
import com.example.SOTIS.model.Guest;

public interface GuestService {
    Guest findById(Long id);
    Guest findByUsername(String username);
    List<Guest> findAll ();
    Guest save(GuestRequest agencyRequest);
}
