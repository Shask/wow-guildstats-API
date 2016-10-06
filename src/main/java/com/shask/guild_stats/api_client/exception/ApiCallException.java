package com.shask.guild_stats.api_client.exception;

/**
 * Created by Steven Fougeron on 06/10/16.
 */
public class ApiCallException extends RuntimeException {

    private ApiCallEnum errorType;

    public ApiCallException(String message, ApiCallEnum errorType) {
        super(message);
        this.errorType = errorType;
    }

    public ApiCallException(String message, Throwable cause, ApiCallEnum errorType) {
        super(message, cause);
        this.errorType = errorType;
    }
}
