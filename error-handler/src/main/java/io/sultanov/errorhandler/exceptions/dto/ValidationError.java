package io.sultanov.errorhandler.exceptions.dto;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class ValidationError {
    private Boolean success;
    private Map<String, Object> errors;

    public ValidationError(Boolean success) {
        this.success = success;
        this.errors = new HashMap<>();
    }

    public void addError(String field, Object message) {
        errors.put(field, message);
    }
}
