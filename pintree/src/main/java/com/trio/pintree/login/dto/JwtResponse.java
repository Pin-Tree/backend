package com.trio.pintree.login.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE, staticName = "create")
public class JwtResponse {

    private final String jwt;
    private final String nickname;
    private final String profile;

}
