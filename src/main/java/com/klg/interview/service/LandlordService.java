package com.klg.interview.service;

import com.klg.interview.domain.Landlord;
import com.klg.interview.repository.LandlordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LandlordService {

    @Autowired
    LandlordRepository landlordRepository;

    public List<Landlord> getAllLandlords() {
        return landlordRepository.findAll();
    }

    public Optional<Landlord> getLandlord(Long id) {
        return landlordRepository.findById(id);
    }

    public Landlord saveLandlord(final Landlord landlord) {
        return landlordRepository.save(landlord);
    }
}
