package com.snumbers.bdpickupws.ui.model.response;

public enum ErrorMessages {
    MISSING_REQUIRED_FIELDS("Missing required fields"),
    INTERNAL_SERVER_ERROR("Internal Server error"),
    AUTHENTICATION_FAILED("Authentication Failed"),
    NO_ORDERS_FOUND("NO Orders Found"),
    SERVICE_UNAVAILABLE("Service unavailable please try later"),
    USER_DOES_NOT_EXIST("User does not exist"),
    LINE_ITEM_DOES_NOT_EXIST("Line item does not exist"),
    INVALID_INPUT_PARAMETERS("Invalid input parameters");


    private String errorMessage;

    ErrorMessages(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
