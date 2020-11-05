package com.girishpore.searchservice.exception;

import org.springframework.http.HttpStatus;

/**
 * Custom exception for search service
 */
public class SearchException extends RuntimeException {
    private final Error error;

    public SearchException(HttpStatus status, String errorMessage) {
        super(errorMessage);
        this.error = new Error(status.name(), status);
    }

    public SearchException(HttpStatus status) {
        this.error = new Error(status.name(), status);
    }

    public SearchException(Error error, String errorMessage) {
        super(errorMessage);
        this.error = error;
    }

    public Error getError() {
        return error;
    }
}