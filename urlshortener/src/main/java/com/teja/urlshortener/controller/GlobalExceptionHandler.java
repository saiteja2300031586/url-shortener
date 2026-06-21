package com.teja.urlshortener.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.teja.urlshortener.service.UrlNotFoundException;
import com.teja.urlshortener.service.UrlExpiredException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UrlNotFoundException.class)
    public ResponseEntity<String> handleUrlNotFound(UrlNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }

    @ExceptionHandler(UrlExpiredException.class)
    public ResponseEntity<String> handleUrlExpired(UrlExpiredException e) {
        return ResponseEntity.status(HttpStatus.GONE).body(e.getMessage());
    }
}