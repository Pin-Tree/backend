package com.trio.pintree.login.exception;

public class NotMatchedUserException extends RuntimeException {

    private static final String NOT_MATCHED_USER_MESSAGE = "적합한 유저를 찾지 못했습니다.";

    public NotMatchedUserException() {
        super(NOT_MATCHED_USER_MESSAGE);
    }
}
