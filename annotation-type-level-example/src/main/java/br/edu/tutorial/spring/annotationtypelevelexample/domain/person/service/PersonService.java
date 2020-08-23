package br.edu.tutorial.spring.annotationtypelevelexample.domain.person.service;

import br.edu.tutorial.spring.annotationtypelevelexample.domain.person.entity.Person;
import br.edu.tutorial.spring.annotationtypelevelexample.domain.person.web.request.PersonRequest;

public interface PersonService {

    Person create(PersonRequest personRequest);
}
