package com.klg.interview.repository;

import com.klg.interview.domain.Property;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public interface PropertyRepository extends CrudRepository<Property, Long> {
    @Override
    List<Property> findAll();

    @Override
    Property save(Property property);

    @Override
    Optional<Property> findById(Long id);

    Optional<Property> findPropertyByName(String propertyName);

    @Override
    void deleteById(Long id);

    @Override
    long count();
}
