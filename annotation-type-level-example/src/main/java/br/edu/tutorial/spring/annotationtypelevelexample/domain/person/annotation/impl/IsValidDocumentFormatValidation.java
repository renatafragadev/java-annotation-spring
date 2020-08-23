package br.edu.tutorial.spring.annotationtypelevelexample.domain.person.annotation.impl;

import br.edu.tutorial.spring.annotationtypelevelexample.domain.person.annotation.IsValidDocumentFormat;
import br.edu.tutorial.spring.annotationtypelevelexample.domain.person.enumerator.DocumentType;
import br.edu.tutorial.spring.annotationtypelevelexample.domain.person.web.request.PersonRequest;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class IsValidDocumentFormatValidation implements ConstraintValidator<IsValidDocumentFormat,
        PersonRequest> {

    @Override
    public boolean isValid(PersonRequest personRequest, ConstraintValidatorContext constraintValidatorContext) {
        final boolean isValidCpf = personRequest.getDocument().length() == 11 && personRequest.getDocumentType()
                .equals(DocumentType.CPF);

        final boolean isValidCnpj = personRequest.getDocument().length() == 14 && personRequest.getDocumentType()
                .equals(DocumentType.CNPJ);

        return isValidCpf || isValidCnpj;
    }
}
