package com.trio.pintree.login.dto;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AuthRequest {
    private final String code;
    private String status;

    private AuthRequest(String code, String status) {
        this(code);
        this.status = status;
    }

    private AuthRequest(String code) {
        this.code = code;
    }

    public static AuthRequest create(String code) {
        return new AuthRequest(code);
    }

    public static AuthRequest create(String code, String status) {
        return new AuthRequest(code, status);
    }

}
