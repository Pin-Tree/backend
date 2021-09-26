package com.trio.pintree.login.util;

import com.trio.pintree.login.exception.JwtException;

public class JwtValidator {

    private static final String BEAER = "bearer";

    public static void validateJwtHeader(String header) {
        String[] split = header.split(" ");
        String tokenType = split[0].toLowerCase();

        if (split.length != 2 || tokenType.equals(BEAER)) {
            throw new JwtException("적합한 JWT의 헤더 형태가 아닙니다.");
        }
    }
}
