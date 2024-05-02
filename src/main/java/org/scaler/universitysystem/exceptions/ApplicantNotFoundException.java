package org.scaler.universitysystem.exceptions;

public class ApplicantNotFoundException extends RuntimeException{
    public ApplicantNotFoundException(Long id) {
        super("Applicant not found with id: " + id);
    }
}
