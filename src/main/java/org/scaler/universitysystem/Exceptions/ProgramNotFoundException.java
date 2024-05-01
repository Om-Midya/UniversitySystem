package org.scaler.universitysystem.Exceptions;

import org.scaler.universitysystem.repository.ProgramRepository;

public class ProgramNotFoundException extends RuntimeException{

    public ProgramNotFoundException(String message){
        super(message);
    }
}
