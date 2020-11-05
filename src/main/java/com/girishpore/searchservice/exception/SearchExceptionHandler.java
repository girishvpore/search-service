package com.girishpore.searchservice.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Objects;

/**
 * Advice for handling exceptions, uses spring AOP feature
 */
@ControllerAdvice
@Slf4j
public class SearchExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler({SearchException.class})
    public ResponseEntity<Error> handleApiException(SearchException ex, WebRequest req) {
        return new ResponseEntity<>(ex.getError(), ex.getError().getStatusCode());
    }

    @ExceptionHandler({Exception.class})
    public ResponseEntity<Error> handleExceptions(Exception ex, WebRequest req) {
        log.error(String.format("Exception while calling api : %s", ex.getMessage()));
        try {
            ResponseEntity<Object> responseEntity = super.handleException(ex, req);
            HttpStatus status = Objects.isNull(responseEntity) ? HttpStatus.INTERNAL_SERVER_ERROR : responseEntity.getStatusCode();
            return new ResponseEntity<>(new Error(ex.getMessage(), status), status);
        } catch (Exception e) {
            return new ResponseEntity<>(new Error(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}