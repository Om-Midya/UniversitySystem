package org.scaler.universitysystem.Exceptions;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter


public class DepartmentNotFoundException extends RuntimeException{

    public DepartmentNotFoundException( String message){
        super(message);
    }

}
