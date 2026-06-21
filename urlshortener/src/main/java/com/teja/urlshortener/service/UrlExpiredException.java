package com.teja.urlshortener.service;

public class UrlExpiredException extends RuntimeException {
    public UrlExpiredException(String message) {
        super(message);
    }
}