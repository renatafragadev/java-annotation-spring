package br.edu.tutorial.spring.annotationfieldlevelexample.domain.person.annotation;

import br.edu.tutorial.spring.annotationfieldlevelexample.domain.person.annotation.impl.GreaterThanOneWorldValidation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Repeatable(GreaterThanOneWord.List.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = GreaterThanOneWorldValidation.class)
public @interface GreaterThanOneWord {

    String message() default "{error.business.greater_than_one_word}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    @Retention(RetentionPolicy.RUNTIME)
    @Target({ElementType.FIELD})
    @interface List {
        GreaterThanOneWord[] value();
    }
}
