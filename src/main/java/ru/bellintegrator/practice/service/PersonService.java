package ru.bellintegrator.practice.service;

import org.springframework.validation.annotation.Validated;
import ru.bellintegrator.practice.view.PersonView;

import javax.validation.Valid;
import java.util.List;

/**
 * Сервис
 */
@Validated
public interface PersonService {

    /**
     * Добавить нового человека в БД
     *
     * @param person
     */
    void add(@Valid PersonView person);

    /**
     * Получить информацию о человеке по id
     *
     * @param id
     */
    PersonView getById(@Valid Long id);

    /**
     * Получить список людей
     *
     * @return {@Person}
     */
    List<PersonView> persons();
}
