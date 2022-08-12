package com.klg.interview.service;

import com.klg.interview.domain.Property;
import com.klg.interview.repository.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PropertyService {

    @Autowired
    PropertyRepository propertyRepository;

    public List<Property> getAllProperties() {
        return propertyRepository.findAll();
    }

    public Optional<Property> getProperty(Long id) {
        return propertyRepository.findById(id);
    }

    public Property saveProperty(final Property property) {
        return propertyRepository.save(property);
    }

    public Property getPropertyByName(String propertyName) {
        Optional<Property> propertyOptional = propertyRepository.findPropertyByName(propertyName);
        return propertyRepository.findPropertyByName(propertyName).get();
    }

    public void deleteProperty(final Long id) {
        propertyRepository.deleteById(id);
    }
}
