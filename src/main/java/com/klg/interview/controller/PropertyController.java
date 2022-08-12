package com.klg.interview.controller;

import com.klg.interview.domain.Property;
import com.klg.interview.exception.NotFoundException;
import com.klg.interview.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/v1/property")
public class PropertyController {

    @Autowired
    PropertyService propertyService;

    @RequestMapping(method = RequestMethod.GET, value = "getProperties")
    public List<Property> getAllProperties() {
        return propertyService.getAllProperties();
    }

    @RequestMapping(method = RequestMethod.GET, value = "getProperty")
    public Property getProperty(@RequestParam Long propertyId) throws NotFoundException {
        return propertyService.getProperty(propertyId).orElseThrow(NotFoundException::new);
    }

    @RequestMapping(method = RequestMethod.GET, value = "getByPropertyName")
    public Property getPropertyByName(@RequestParam String name) {
        return propertyService.getPropertyByName(name);
    }

    @RequestMapping(method = RequestMethod.POST, value = "createProperty", consumes = APPLICATION_JSON_VALUE)
    public void createProperty(@RequestBody Property property) {
        propertyService.saveProperty(property);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "updateProperty")
    public Property updateProperty(@RequestBody Property property) {
        return propertyService.saveProperty(property);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteProperty")
    public void deleteProperty(@RequestParam Long propertyId) {
        propertyService.deleteProperty(propertyId);
    }
}
