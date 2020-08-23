package br.edu.tutorial.spring.annotationtypelevelexample.infrastructure.general.error.pojo;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class HttpErrorResponse implements Serializable {

    private static final long serialVersionUID = -5023205815975823321L;

    private final long timestamp;
    private final String date;
    private final String status;
    private final List<HttpErrorResponseDetail> details;

    public HttpErrorResponse(List<HttpErrorResponseDetail> details) {
        this.timestamp = System.currentTimeMillis();
        this.date =  LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss"));
        this.status = "error";
        this.details = details;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public String getDate() {
        return date;
    }

    public String getStatus() {
        return status;
    }

    public List<HttpErrorResponseDetail> getDetails() {
        return details;
    }

    @Override
    public String toString() {
        return "HttpErrorResponse{" +
                "timestamp=" + timestamp +
                ", date='" + date + '\'' +
                ", status='" + status + '\'' +
                ", details=" + details +
                '}';
    }
}
