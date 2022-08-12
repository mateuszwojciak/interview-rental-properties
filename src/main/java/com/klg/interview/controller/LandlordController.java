package com.klg.interview.controller;

import com.klg.interview.domain.Landlord;
import com.klg.interview.exception.NotFoundException;
import com.klg.interview.service.LandlordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/v1/landlord")
public class LandlordController {

    @Autowired
    LandlordService landlordService;

    @RequestMapping(method = RequestMethod.GET, value = "getLandlords")
    public List<Landlord> getAllLandlords() {
        return landlordService.getAllLandlords();
    }

    @RequestMapping(method = RequestMethod.GET, value = "getLandlord")
    public Landlord getLandlord(@RequestParam Long landlordId) throws NotFoundException {
        return landlordService.getLandlord(landlordId).orElseThrow(NotFoundException::new);
    }

    @RequestMapping(method = RequestMethod.POST, value = "createLandlord", consumes = APPLICATION_JSON_VALUE)
    public void createLandlord(@RequestBody Landlord landlord) {
        landlordService.saveLandlord(landlord);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "updateLandlord")
    public Landlord updateLandlord(@RequestBody Landlord landlord) {
        return landlordService.saveLandlord(landlord);
    }
}
