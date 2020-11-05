package com.girishpore.searchservice.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.util.Date;

/**
 * Class to store error details
 */
@Data
public class Error {
    private String message;
    private String details;
    private HttpStatus statusCode;
    private Date timestamp;

    public Error(String message, String details, HttpStatus statusCode) {
        this.message = message;
        this.details = details;
        this.timestamp = new Date();
        this.statusCode = statusCode;
    }

    public Error(String message, HttpStatus statusCode) {
        this.message = message;
        this.details = message;
        this.timestamp = new Date();
        this.statusCode = statusCode;
    }


}