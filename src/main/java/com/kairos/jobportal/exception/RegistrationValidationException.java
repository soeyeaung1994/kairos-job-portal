package com.kairos.jobportal.exception;

import java.util.Map;

/**
 * @Author: Soe Ye Aung
 * @Date: 19/3/26
 * @Time: 3:08 pm
 */


public class RegistrationValidationException extends RuntimeException {

    private final Map<String, String> errors;

    public RegistrationValidationException(Map<String, String> errors) {
        super("Registration validation failed");
        this.errors = errors;
    }

    public Map<String, String> getErrors() {
        return errors;
    }
}
