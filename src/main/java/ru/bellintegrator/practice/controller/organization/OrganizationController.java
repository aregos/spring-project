package ru.bellintegrator.practice.controller.organization;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.bellintegrator.practice.model.Organization;
import ru.bellintegrator.practice.model.OrganizationFilter;
import ru.bellintegrator.practice.service.OrganizationService;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/api/organization", produces = APPLICATION_JSON_VALUE)
public class OrganizationController {

    private final OrganizationService organizationService;

    @Autowired
    public OrganizationController(OrganizationService organizationService) {
        this.organizationService = organizationService;
    }

    @PostMapping("/list")
    public List<Organization> getOrganizationList(@RequestBody OrganizationFilter filter) throws Exception {
        return organizationService.getOrganizationList(filter);
    }

    @GetMapping("/{id}")
    public Organization getOrganizationById(@PathVariable Long id) throws Exception {
        return organizationService.getOrganizationById(id);
    }

}
