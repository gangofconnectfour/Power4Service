package com.gangofconnectfour.powerfourservice.facade.exception;

public class RessourceNotFoundException extends Exception {

    public RessourceNotFoundException(String message) {
        super ("Resource non trouve : "+ message);
    }
}
