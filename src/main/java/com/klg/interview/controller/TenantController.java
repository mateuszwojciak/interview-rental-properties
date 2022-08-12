package com.klg.interview.controller;

import com.klg.interview.domain.Tenant;
import com.klg.interview.exception.NotFoundException;
import com.klg.interview.service.TenantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/v1/tenant")
public class TenantController {

    @Autowired
    TenantService tenantService;

    @RequestMapping(method = RequestMethod.GET, value = "getTenants")
    public List<Tenant> getAllTenants() {
        return tenantService.getAllTenants();
    }

    @RequestMapping(method = RequestMethod.GET, value = "getTenant")
    public Tenant getTenant(@RequestParam Long tenantId) throws NotFoundException {
        return tenantService.getTenant(tenantId).orElseThrow(NotFoundException::new);
    }

    @RequestMapping(method = RequestMethod.POST, value = "createTenant", consumes = APPLICATION_JSON_VALUE)
    public void createTenant(@RequestBody Tenant tenant) {
        tenantService.saveTenant(tenant);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "updateTenant")
    public Tenant updateTenant(@RequestBody Tenant tenant) {
        return tenantService.saveTenant(tenant);
    }

    @RequestMapping(method = RequestMethod.GET, value = "getByTenantName")
    public Tenant getTenantByName(@RequestParam String name) {
        return tenantService.getTenantByName(name);
    }
}
