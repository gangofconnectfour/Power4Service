package com.gangofconnectfour.powerfourservice.facade.exception;

public class UUIDException extends Exception {

    public UUIDException() {
        super("UUID is missing");
    }
}
