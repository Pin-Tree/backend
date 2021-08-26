package com.trio.pintree.login.exception;

public class JwtException extends RuntimeException {
    public JwtException() {
        super();
    }

    public JwtException(String message, Throwable cause) {
        super(message, cause);
    }

    public JwtException(Throwable cause) {
        super(cause);
    }

    public JwtException(String message) {
        super(message);
    }
}

