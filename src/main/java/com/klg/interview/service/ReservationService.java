package com.klg.interview.service;

import com.klg.interview.domain.Landlord;
import com.klg.interview.domain.Property;
import com.klg.interview.domain.Reservation;
import com.klg.interview.domain.Tenant;
import com.klg.interview.exception.InvalidInputException;
import com.klg.interview.repository.LandlordRepository;
import com.klg.interview.repository.PropertyRepository;
import com.klg.interview.repository.ReservationRepository;
import com.klg.interview.repository.TenantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {

    @Autowired
    ReservationRepository reservationRepository;

    @Autowired
    LandlordRepository landlordRepository;

    @Autowired
    PropertyRepository propertyRepository;

    @Autowired
    TenantRepository tenantRepository;

    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    public Optional<Reservation> getReservation(Long id) {
        return reservationRepository.findById(id);
    }

    public Reservation saveReservation(final Reservation reservation) {
        Optional<Landlord> landlordOptional = landlordRepository.findById(reservation.getId_landlord());
        Landlord landlord = landlordOptional.get();
        reservation.setLandlord(landlord);

        Optional<Tenant> tenantOptional = tenantRepository.findById(reservation.getId_tenant());
        Tenant tenant = tenantOptional.get();
        reservation.setTenant(tenant);

        Optional<Property> propertyOptional = propertyRepository.findById(reservation.getId_property());
        Property property = propertyOptional.get();
        reservation.setProperty(property);

        List<Reservation> reservedObjectList = reservationRepository.findByPropertyName(property.getName());

        LocalDate startDate = reservation.getRentalPeriodStart();
        reservation.setRentalPeriodStart(startDate);

        LocalDate endDate = reservation.getRentalPeriodEnd();
        reservation.setRentalPeriodEnd(endDate);

        boolean isAlreadyReserved = reservedObjectList.stream()
                .anyMatch(reservationCheck -> reservationCheck.getRentalPeriodEnd().isAfter(reservation.getRentalPeriodStart())
                && reservationCheck.getRentalPeriodStart().isBefore(reservation.getRentalPeriodEnd()));
        if(isAlreadyReserved)
            throw new InvalidInputException("Nie można zarezerwować tego obiektu, bo obiekt jest w tym czasie wynajmowany");

        if(reservation.getRentalPeriodEnd().isBefore(reservation.getRentalPeriodStart()))
            throw new InvalidInputException("Data rozpoczęcia wynajmu musi być wcześniej niż data zakończenia");

        return reservationRepository.save(reservation);
    }

    public void deleteReservation(final Long id) {
        reservationRepository.deleteById(id);
    }

    public List<Reservation> getReservationsForTenant(String tenantName) {
        return reservationRepository.findByTenantName(tenantRepository.findByName(tenantName).get().getName());
    }

    public List<Reservation> getReservationsForProperty(String propertyName) {
        return reservationRepository.findByPropertyName(propertyRepository.findPropertyByName(propertyName).get().getName());
    }
}
