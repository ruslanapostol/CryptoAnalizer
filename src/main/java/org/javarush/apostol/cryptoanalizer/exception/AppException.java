package org.javarush.apostol.cryptoanalizer.exception;


public class AppException extends RuntimeException {
    public AppException(String message, Throwable cause) {
        super(message, cause);
    }
}

