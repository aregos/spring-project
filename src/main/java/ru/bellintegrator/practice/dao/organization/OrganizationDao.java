package ru.bellintegrator.practice.dao.organization;

import ru.bellintegrator.practice.model.Organization;
import ru.bellintegrator.practice.model.OrganizationFilter;

import java.util.List;

/**
 * DAO для работы с Organization
 */
public interface OrganizationDao {
    /**
     * Получить все объекты Organization
     *
     * @return
     */
    List<Organization> all();

    /**
     * Получить Organization по идентификатору
     *
     * @param id
     * @return
     */
    Organization loadById(Long id);

    /**
     * Сохранить House
     *
     * @param house
     */
    void save(Organization house);

    /**
     * Получить список Organization по фильтру
     * @param filter
     * @return
     */
    List<Organization> getByFilter(OrganizationFilter filter);
}
