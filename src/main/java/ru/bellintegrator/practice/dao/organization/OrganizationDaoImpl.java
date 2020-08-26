package ru.bellintegrator.practice.dao.organization;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.bellintegrator.practice.model.Organization;
import ru.bellintegrator.practice.model.OrganizationFilter;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * {@inheritDoc}
 */
@Repository
public class OrganizationDaoImpl implements OrganizationDao {

    private final EntityManager em;

    @Autowired
    public OrganizationDaoImpl(EntityManager em) {
        this.em = em;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Organization> all() {
        TypedQuery<Organization> query = em.createQuery("SELECT o FROM Organization o", Organization.class);
        return query.getResultList();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Organization loadById(Long id) {
        return em.find(Organization.class, id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void save(Organization house) {
        em.persist(house);
    }

    @Override
    public List<Organization> getByFilter(OrganizationFilter filter) {
        String name = filter.getName();
        Integer inn = filter.getInn();
        Boolean isActive = filter.getActive();
        String preparedQuery = String.format("name = %s, inn = %d, isActive = %b", name, inn, isActive);
        TypedQuery<Organization> query = em.createQuery("SELECT o FROM Organization o WHERE " + preparedQuery, Organization.class);
        List<Organization> res = query.getResultList();
        return res;
    }
}
