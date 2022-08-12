package com.klg.interview.repository;

import com.klg.interview.domain.Tenant;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public interface TenantRepository extends CrudRepository<Tenant, Long> {
    @Override
    List<Tenant> findAll();

    @Override
    Tenant save(Tenant tenant);

    @Override
    Optional<Tenant> findById(Long id);

    Optional<Tenant> findByName(String tenantName);

    @Override
    long count();
}
