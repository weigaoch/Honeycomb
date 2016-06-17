package com.polycom.rest;

/**
 * Created by wgao on 6/16/2016.
 */
public class RestException extends RuntimeException {
    public final int statusCode;

    public RestException(int statusCode) {
        super();
        this.statusCode = statusCode;
    }

    public RestException(int statusCode, String message) {
        super(message);
        this.statusCode = statusCode;
    }
}
