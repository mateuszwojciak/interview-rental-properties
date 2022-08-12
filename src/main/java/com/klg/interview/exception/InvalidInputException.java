package com.klg.interview.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class InvalidInputException extends ResponseStatusException {
    public InvalidInputException(String reason) {
        super(HttpStatus.UNPROCESSABLE_ENTITY, reason);
    }
}
