package com.klg.interview.controller;

import com.klg.interview.domain.Reservation;
import com.klg.interview.exception.NotFoundException;
import com.klg.interview.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/v1/reservation")
public class ReservationController {

    @Autowired
    ReservationService reservationService;

    @RequestMapping(method = RequestMethod.GET, value = "getReservations")
    public List<Reservation> getAllReservations() {
        return reservationService.getAllReservations();
    }

    @RequestMapping(method = RequestMethod.GET, value = "getReservation")
    public Reservation getReservation(@RequestParam Long reservationId) throws NotFoundException {
        return reservationService.getReservation(reservationId).orElseThrow(NotFoundException::new);
    }

    @RequestMapping(method = RequestMethod.POST, value = "createReservation", consumes = APPLICATION_JSON_VALUE)
    public void createReservation(@RequestBody Reservation reservation) {
        reservationService.saveReservation(reservation);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "updateReservation")
    public Reservation updateReservation(@RequestBody Reservation reservation) {
        return reservationService.saveReservation(reservation);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteReservation")
    public void deleteReservation(@RequestParam Long reservationId) {
        reservationService.deleteReservation(reservationId);
    }

    @RequestMapping(method = RequestMethod.GET, value = "searchByTenant")
    public List<Reservation> getReservationsForTenant(@RequestParam String tenantName) {
        return reservationService.getReservationsForTenant(tenantName);
    }

    @RequestMapping(method = RequestMethod.GET, value = "searchByProperty")
    public List<Reservation> getReservationsForProperty(@RequestParam String propertyName) {
        return reservationService.getReservationsForProperty(propertyName);
    }
}
