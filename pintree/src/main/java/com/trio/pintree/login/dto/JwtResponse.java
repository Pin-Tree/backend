package com.trio.pintree.login.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@RequiredArgsConstructor(staticName = "create")
public class JwtResponse {

    private final String jwt;
    private final MemberResponseDto member;

}
