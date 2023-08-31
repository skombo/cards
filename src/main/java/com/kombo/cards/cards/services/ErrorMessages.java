package com.kombo.cards.cards.services;

public enum ErrorMessages {
    CARD_NOT_FOUND("Card Not Found"),
    CARD_ALREADY_EXISTS("Card Already Exists"),
    USER_ALREADY_EXISTS("User Already Exists"),
    USER_NOT_FOUND("User Not Found");
    private String message;

    ErrorMessages(String message){
        this.message=message;

    }

    public String getErrorMessage(){
        return message;
    }

    public void setErrorMessage(String errorMessage){
        this.message=errorMessage;
    }
}
