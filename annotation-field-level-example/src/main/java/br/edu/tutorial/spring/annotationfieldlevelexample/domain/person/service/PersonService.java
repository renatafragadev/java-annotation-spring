package br.edu.tutorial.spring.annotationfieldlevelexample.domain.person.service;

import br.edu.tutorial.spring.annotationfieldlevelexample.domain.person.entity.Person;
import br.edu.tutorial.spring.annotationfieldlevelexample.domain.person.web.request.PersonRequest;

public interface PersonService {

    Person create(PersonRequest personRequest);
}
