package com.trio.pintree.login.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Builder
@RequiredArgsConstructor
@Getter
@ToString
public class GoogleAccessTokenRequest {
    private final String clientId;
    private final String clientSecret;
    private final String redirectUri;
    private final String grantType;
    private final String code;
}
