package com.klg.interview.repository;

import com.klg.interview.domain.Reservation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public interface ReservationRepository extends CrudRepository<Reservation, Long> {
    @Override
    List<Reservation> findAll();

    @Override
    Optional<Reservation> findById(Long id);

    @Override
    Reservation save(Reservation reservation);

    @Override
    void deleteById(Long id);

    @Override
    long count();

    List<Reservation> findByTenantName(String tenantName);

    List<Reservation> findByPropertyName(String propertyName);
}
