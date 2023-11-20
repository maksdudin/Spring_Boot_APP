package ru.javarush.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.time.LocalDateTime;
import java.util.List;
import liquibase.repackaged.net.sf.jsqlparser.util.validation.ValidationError;
import lombok.Getter;

@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RestExceptionResponse {

    private final String uuid;
    private final LocalDateTime timestamp;
    private final Integer status;
    private final String path;
    private final String code;
    private final String message;
    private List<ValidationError> errors;

    public RestExceptionResponse(String uuid, Integer status, String path, String code,
                                 String message, List<ValidationError> errors) {
        this.uuid = uuid;
        this.timestamp = LocalDateTime.now();
        this.status = status;
        this.path = path;
        this.code = code;
        this.message = message;
        this.errors = errors;
    }

    public RestExceptionResponse(String uuid, Integer status, String path, String code,
                                 String message) {
        this.uuid = uuid;
        this.timestamp = LocalDateTime.now();
        this.status = status;
        this.path = path;
        this.code = code;
        this.message = message;
    }

    public static RestExceptionResponse of(String uuid, Integer status, String path, String code,
                                           String message, List<ValidationError> errors) {
        return new RestExceptionResponse(uuid, status, path, code, message, errors);
    }

    public static RestExceptionResponse of(String uuid, Integer status, String path, String code,
                                           String message) {
        return new RestExceptionResponse(uuid, status, path, code, message);
    }

}