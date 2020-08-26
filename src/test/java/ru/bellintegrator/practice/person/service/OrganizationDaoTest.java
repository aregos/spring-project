package ru.bellintegrator.practice.person.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;
import ru.bellintegrator.practice.Application;
import ru.bellintegrator.practice.dao.organization.OrganizationDao;
import ru.bellintegrator.practice.model.Organization;
import ru.bellintegrator.practice.model.Person;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class})
@WebAppConfiguration(value = "src/main/resources")
@Transactional
@DirtiesContext
public class OrganizationDaoTest {

    @Autowired
    private OrganizationDao organizationDao;

    @Test
    public void test() {
        Organization organization = new Organization();
        Set<Person> list = new HashSet<>();
        organization.setAddress("Address");
        Person person = new Person("One", 1);
        person.addOrganization(organization);
        organization.setPersons(list);
        list.add(person);
        organizationDao.save(organization);

        List<Organization> organizations = organizationDao.all();
        Assert.assertNotNull(organizations);

        person.addOrganization(organization);

        Assert.assertFalse(organizations.isEmpty());

        Set<Person> persons = organizations.get(1).getPersons();

        Assert.assertNotNull(persons);
        Assert.assertEquals(1, persons.size());

        Person person1 = new Person("Two", 2);
        list.add(person1);

        organizations = organizationDao.all();
        persons = organizations.get(1).getPersons();
        Assert.assertNotNull(person);
        Assert.assertEquals(1, persons.size());
    }
}