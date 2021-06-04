package com.test.falabella.exceptions;

public class NotValidUrlException extends RuntimeException{

    public NotValidUrlException(String url) {
        super(String.format("Not valid url: %s",url));
    }
}
