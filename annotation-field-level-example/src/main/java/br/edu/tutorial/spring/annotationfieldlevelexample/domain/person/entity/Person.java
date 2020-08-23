package br.edu.tutorial.spring.annotationfieldlevelexample.domain.person.entity;

import br.edu.tutorial.spring.annotationfieldlevelexample.domain.person.enumerator.DocumentType;

public class Person {

    private Long id;
    private String firstName;
    private String lastName;
    private DocumentType documentType;
    private String document;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public DocumentType getDocumentType() {
        return documentType;
    }

    public void setDocumentType(DocumentType documentType) {
        this.documentType = documentType;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }
}
