package org.scaler.universitysystem.exceptions;

public class AdmissionNotFoundException extends RuntimeException{
    public AdmissionNotFoundException(Long id) {
        super("Admission not found with id: " + id);
    }
}
