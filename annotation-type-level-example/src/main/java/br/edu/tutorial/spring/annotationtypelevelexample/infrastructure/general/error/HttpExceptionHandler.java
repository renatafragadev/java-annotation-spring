package br.edu.tutorial.spring.annotationtypelevelexample.infrastructure.general.error;

import br.edu.tutorial.spring.annotationtypelevelexample.infrastructure.general.error.enumerator.ErrorCode;
import br.edu.tutorial.spring.annotationtypelevelexample.infrastructure.general.error.pojo.HttpErrorResponse;
import br.edu.tutorial.spring.annotationtypelevelexample.infrastructure.general.error.pojo.HttpErrorResponseDetail;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class HttpExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers, HttpStatus status,
                                                                  WebRequest request) {
        List<HttpErrorResponseDetail> details = new ArrayList<>();

        for (ObjectError objectError : ex.getBindingResult().getAllErrors()) {
            if (objectError instanceof FieldError) {
                details.add(new HttpErrorResponseDetail(objectError.getObjectName(),
                        objectError.getDefaultMessage(), ((FieldError) objectError).getField(),
                        ErrorCode.MISSING_FIELD));
            } else {
                details.add(new HttpErrorResponseDetail(objectError.getObjectName(),
                        objectError.getDefaultMessage(), ErrorCode.MISSING_FIELD));
            }
        }

        return new ResponseEntity<>(new HttpErrorResponse(details), new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }

}
