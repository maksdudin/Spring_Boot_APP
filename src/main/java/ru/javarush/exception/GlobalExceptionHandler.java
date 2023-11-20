package ru.javarush.exception;

import java.util.UUID;
import javax.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.TransactionTimedOutException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
@RequiredArgsConstructor
public class GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ResourceNotFoundException.class)
    public RestExceptionResponse handleServiceExceptions(ResourceNotFoundException ex,
                                                         HttpServletRequest request) {
        var processKey = UUID.randomUUID().toString();

        log.error("Service error, status: uuid: {}, message: {}",
                processKey, ex.getMessage());

        return RestExceptionResponse.of(processKey,
                HttpStatus.NOT_FOUND.value(),
                request.getRequestURI(),
                "1",
                ex.getMessage());
    }

    @ResponseStatus(HttpStatus.GATEWAY_TIMEOUT) // 504
    @ExceptionHandler(TransactionTimedOutException.class)
    public RestExceptionResponse handleServiceExceptions(TransactionTimedOutException ex,
                                                         HttpServletRequest request) {
        var processKey = UUID.randomUUID().toString();

        log.error("Service error, status: uuid: {}, message: {}",
                processKey, ex.getMessage());

        return RestExceptionResponse.of(processKey,
                HttpStatus.NOT_FOUND.value(),
                request.getRequestURI(),
                "1",
                ex.getMessage());
    }

}
