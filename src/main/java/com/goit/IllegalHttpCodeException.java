package com.goit;

public class IllegalHttpCodeException extends RuntimeException{

    public IllegalHttpCodeException(Throwable throwable) {
        super(throwable);
    }

    public IllegalHttpCodeException(String message) {
        super(message);
    }
}
