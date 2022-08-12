package com.klg.interview.service;

import com.klg.interview.domain.Tenant;
import com.klg.interview.repository.TenantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TenantService {

    @Autowired
    TenantRepository tenantRepository;

    public List<Tenant> getAllTenants() {
        return tenantRepository.findAll();
    }

    public Optional<Tenant> getTenant(Long id) {
        return tenantRepository.findById(id);
    }

    public Tenant saveTenant(final Tenant tenant) {
        return tenantRepository.save(tenant);
    }

    public Tenant getTenantByName(String tenantName) {
        Optional<Tenant> tenantOptional = tenantRepository.findByName(tenantName);
        return tenantRepository.findByName(tenantName).get();
    }
}
