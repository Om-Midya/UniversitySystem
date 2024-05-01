package org.scaler.universitysystem.exceptions;

public class InsufficientDataException extends RuntimeException{
    public InsufficientDataException(String message) {
        super("Insufficient data provided: " + message);
    }
}
