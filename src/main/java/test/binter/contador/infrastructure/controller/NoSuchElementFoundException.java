package test.binter.contador.infrastructure.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.HttpMediaTypeException;
import org.springframework.web.server.ResponseStatusException;

public class NoSuchElementFoundException extends ResponseStatusException {

    public NoSuchElementFoundException(String message){
        super(HttpStatus.NOT_FOUND, message);
    }
}