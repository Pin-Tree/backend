package com.trio.pintree.login.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class AuthResponse implements AccessTokenResponse{
    private final String token;
}
