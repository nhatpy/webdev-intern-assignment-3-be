package com.g_scrores.g_scores.exception;

public enum ErrorCode {
    UNCATEGORIZED_ERROR("Uncategorized error occurred"),
    INVALID_INPUT("Invalid registration number"),
    ;

    String message;

    ErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
