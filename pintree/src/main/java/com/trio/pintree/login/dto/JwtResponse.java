package com.trio.pintree.login.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(staticName = "create")
public class JwtResponse {

    private final String jwt;
    private final MemberResponseDto member;

}
