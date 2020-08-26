package ru.bellintegrator.practice.controller.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import ru.bellintegrator.practice.responsewrappers.FailureWrapper;
import ru.bellintegrator.practice.service.PersonService;
import ru.bellintegrator.practice.view.PersonView;

import javax.servlet.http.HttpServletRequestWrapper;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/api/user", produces = APPLICATION_JSON_VALUE)
//@ControllerAdvice
public class PersonController extends ResponseEntityExceptionHandler {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping("/person")
    public void person(@RequestBody PersonView person) {
        personService.add(person);
    }

    @GetMapping("/{id}")
    public PersonView getById(@PathVariable @RequestBody Long id) {
        return personService.getById(id);
    }

    @GetMapping("/list")
    @ResponseBody
    public List<PersonView> persons() throws Exception {
//        throw new Exception("Не удалось вернуть список");
        return personService.persons();
    }
}
