package org.zayim.model;

import org.springframework.validation.ObjectError;

public class SuperheroError {

    private String errorMessage;

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public static SuperheroError of(Object error) {
        SuperheroError superheroError = new SuperheroError();
        superheroError.setErrorMessage(error != null ? error.toString() : "null");
        return superheroError;
    }

    public static SuperheroError of (ObjectError objectError) {
        SuperheroError superheroError = new SuperheroError();
        superheroError.setErrorMessage(objectError != null ?
                objectError.getObjectName() + " " + objectError.getDefaultMessage() :
                "null");
        return superheroError;
    }
}
