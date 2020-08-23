package br.edu.tutorial.spring.annotationtypelevelexample.domain.person.annotation;

import br.edu.tutorial.spring.annotationtypelevelexample.domain.person.annotation.impl.IsValidDocumentFormatValidation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = IsValidDocumentFormatValidation.class)
public @interface IsValidDocumentFormat {

    String message() default "{error.business.is_valid_document_format}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
