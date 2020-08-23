package br.edu.tutorial.spring.annotationtypelevelexample.domain.person.service.impl;

import br.edu.tutorial.spring.annotationtypelevelexample.domain.person.entity.Person;
import br.edu.tutorial.spring.annotationtypelevelexample.domain.person.service.PersonService;
import br.edu.tutorial.spring.annotationtypelevelexample.domain.person.web.request.PersonRequest;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements PersonService {

    @Override
    public Person create(PersonRequest personRequest) {
        Person person = new Person();
        person.setId(1L);
        person.setDocument(personRequest.getDocument());

        return person;
    }
}
