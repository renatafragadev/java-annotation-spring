package br.edu.tutorial.spring.annotationfieldlevelexample.domain.person.annotation.impl;

import br.edu.tutorial.spring.annotationfieldlevelexample.domain.person.annotation.GreaterThanOneWord;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class GreaterThanOneWorldValidation implements ConstraintValidator<GreaterThanOneWord, String> {

    @Override
    public boolean isValid(String field, ConstraintValidatorContext constraintValidatorContext) {
        return field.split(" ").length > 1;
    }
}
