package com.sysmap.redesocial.infra.exceptions;

import org.springframework.validation.FieldError;

public record ValidationDataError(String field, String message) {
    public ValidationDataError(FieldError error) {
        this(error.getField(), error.getDefaultMessage());
    }
}