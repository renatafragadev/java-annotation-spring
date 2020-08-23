package br.edu.tutorial.spring.annotationtypelevelexample.domain.person.web;

import br.edu.tutorial.spring.annotationtypelevelexample.domain.person.entity.Person;
import br.edu.tutorial.spring.annotationtypelevelexample.domain.person.service.PersonService;
import br.edu.tutorial.spring.annotationtypelevelexample.domain.person.web.request.PersonRequest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "/v1/persons", produces = MediaType.APPLICATION_JSON_VALUE)
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> create(@Valid @RequestBody PersonRequest personRequest) {

        Person person = personService.create(personRequest);

        return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(person.getId())
                .toUri()).build();
    }
}
