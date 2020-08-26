package ru.bellintegrator.practice.service;

import org.springframework.validation.annotation.Validated;
import ru.bellintegrator.practice.model.Organization;
import ru.bellintegrator.practice.model.OrganizationFilter;

import java.util.List;

@Validated
public interface OrganizationService {

    List<Organization> getOrganizationList(OrganizationFilter filter);

    Organization getOrganizationById(Long id);
}
