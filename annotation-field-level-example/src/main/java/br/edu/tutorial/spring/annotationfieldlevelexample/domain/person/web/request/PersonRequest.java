package br.edu.tutorial.spring.annotationfieldlevelexample.domain.person.web.request;

import br.edu.tutorial.spring.annotationfieldlevelexample.domain.person.annotation.GreaterThanOneWord;
import br.edu.tutorial.spring.annotationfieldlevelexample.domain.person.enumerator.DocumentType;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class PersonRequest {

    @GreaterThanOneWord
    @NotBlank
    private String fullName;

    @NotBlank
    private String document;

    @NotNull
    private DocumentType documentType;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public DocumentType getDocumentType() {
        return documentType;
    }

    public void setDocumentType(DocumentType documentType) {
        this.documentType = documentType;
    }

    @Override
    public String toString() {
        return "PersonRequest{" +
                "fullName='" + fullName + '\'' +
                ", document='" + document + '\'' +
                ", documentType=" + documentType +
                '}';
    }
}

