package com.mervy;

public class NonProfitException extends Exception {
    public NonProfitException() {
        super("No Profit Mission !!!");
    }

    public NonProfitException(String message) {
        super(message);
    }
}
