package com.klg.interview.repository;

import com.klg.interview.domain.Landlord;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public interface LandlordRepository extends CrudRepository<Landlord, Long> {
    @Override
    List<Landlord> findAll();

    @Override
    Landlord save(Landlord landlord);

    @Override
    Optional<Landlord> findById(Long id);

    @Override
    long count();
}
