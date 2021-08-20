package com.trio.pintree.login.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class AuthResponse {
    private final String token;
}
