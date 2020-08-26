package ru.bellintegrator.practice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.bellintegrator.practice.dao.organization.OrganizationDao;
import ru.bellintegrator.practice.model.Organization;
import ru.bellintegrator.practice.model.OrganizationFilter;
import ru.bellintegrator.practice.model.mapper.MapperFacade;

import java.util.List;

@Service
public class OrganizationServiceImpl implements OrganizationService {
    MapperFacade mapperFacade;
    OrganizationDao organizationDao;

    @Autowired
    public OrganizationServiceImpl(MapperFacade mapperFacade, OrganizationDao organizationDao) {
        this.mapperFacade = mapperFacade;
        this.organizationDao = organizationDao;
    }

    @Override
    public List<Organization> getOrganizationList(OrganizationFilter filter) {
        List<Organization> res = organizationDao.getByFilter(filter);
        return res;
    }

    @Override
    public Organization getOrganizationById(Long id) {
        Organization org = organizationDao.loadById(id);
        return org;
    }
}
