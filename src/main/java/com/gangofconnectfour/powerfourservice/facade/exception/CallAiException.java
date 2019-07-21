package com.gangofconnectfour.powerfourservice.facade.exception;

public class CallAiException extends RuntimeException {

    public CallAiException() {
        super("Erreur durrand le call a l'IA");
    }
}
