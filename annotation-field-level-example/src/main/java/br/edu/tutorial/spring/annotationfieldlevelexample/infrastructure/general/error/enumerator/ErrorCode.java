package br.edu.tutorial.spring.annotationfieldlevelexample.infrastructure.general.error.enumerator;

public enum ErrorCode {
    MISSING_FIELD("missing_field");

    private final String code;

    ErrorCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
