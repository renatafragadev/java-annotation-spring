package br.edu.tutorial.spring.annotationfieldlevelexample.domain.person.web;

import br.edu.tutorial.spring.annotationfieldlevelexample.domain.person.entity.Person;
import br.edu.tutorial.spring.annotationfieldlevelexample.domain.person.enumerator.DocumentType;
import br.edu.tutorial.spring.annotationfieldlevelexample.domain.person.service.PersonService;
import br.edu.tutorial.spring.annotationfieldlevelexample.domain.person.web.request.PersonRequest;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@ExtendWith(SpringExtension.class)
@AutoConfigureJsonTesters
@WebMvcTest(PersonController.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class PersonControllerUT {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private JacksonTester<PersonRequest> jacksonTesterPerson;

    @MockBean
    private PersonService personService;

    private Person person;

    @BeforeAll
    void init() {
        createPersons();
    }

    @DisplayName("Should create person successfully")
    @Test
    void create_ResourceIsValid_ReturnStatusCreated() throws Exception {
        PersonRequest personRequest = new PersonRequest();
        personRequest.setFullName("Lara Moreira da Silva");
        personRequest.setDocument("88451490050");
        personRequest.setDocumentType(DocumentType.CPF);

        when(personService.create(any(PersonRequest.class))).thenReturn(person);

        MockHttpServletResponse response = mockMvc.perform(
                post("/v1/persons")
                        .content(jacksonTesterPerson.write(personRequest).getJson())
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andReturn().getResponse();

        assertEquals(HttpStatus.CREATED.value(), response.getStatus());
    }


    @DisplayName("Should return error because the name was not complete")
    @Test
    void create_FullNameHasAWord_BadRequest() throws Exception {
        PersonRequest personRequest = new PersonRequest();
        personRequest.setFullName("Marcos");
        personRequest.setDocument("88451490050");
        personRequest.setDocumentType(DocumentType.CPF);

        when(personService.create(any(PersonRequest.class))).thenReturn(person);

        MockHttpServletResponse response = mockMvc.perform(
                post("/v1/persons")
                        .content(jacksonTesterPerson.write(personRequest).getJson())
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andReturn().getResponse();

        assertEquals(HttpStatus.BAD_REQUEST.value(), response.getStatus());
    }

    private void createPersons() {
        person = new Person();
        person.setId(1L);
        person.setFirstName("Lara");
        person.setLastName("Moreira da Silva");
        person.setDocumentType(DocumentType.CPF);
        person.setDocument("88451490050");
    }
}
