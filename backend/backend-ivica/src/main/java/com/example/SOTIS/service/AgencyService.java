package com.example.SOTIS.service;

import java.util.List;

import com.example.SOTIS.dto.AgencyRequest;
import com.example.SOTIS.model.Agency;

public interface AgencyService {
    Agency findById(Long id);
    Agency findByUsername(String username);
    List<Agency> findAll ();
    Agency save(AgencyRequest agencyRequest);
}
