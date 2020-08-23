package br.edu.tutorial.spring.annotationfieldlevelexample.infrastructure.general.error.pojo;

import br.edu.tutorial.spring.annotationfieldlevelexample.infrastructure.general.error.enumerator.ErrorCode;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

public class HttpErrorResponseDetail implements Serializable {

    private static final long serialVersionUID = 5435591248988950081L;

    private final String resource;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String field;

    private final String message;

    private final ErrorCode code;

    public HttpErrorResponseDetail(String resource, String field, String message, ErrorCode code) {
        this.resource = resource;
        this.field = field;
        this.message = message;
        this.code = code;
    }

    public HttpErrorResponseDetail(String resource, String message, ErrorCode code) {
        this.resource = resource;
        this.message = message;
        this.code = code;
    }

    public String getResource() {
        return resource;
    }

    public String getField() {
        return field;
    }

    public String getMessage() {
        return message;
    }

    public ErrorCode getCode() {
        return code;
    }

    @Override
    public String toString() {
        return "HttpErrorResponseDetail{" +
                "resource='" + resource + '\'' +
                ", field='" + field + '\'' +
                ", message='" + message + '\'' +
                ", code=" + code +
                '}';
    }
}
