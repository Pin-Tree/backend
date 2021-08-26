package com.trio.pintree.login.dto.oauth;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Builder
@Getter
@ToString
@RequiredArgsConstructor
public class GoogleAccessTokenRequest {

    private final String clientId;
    private final String clientSecret;
    private final String redirectUri;
    private final String grantType;
    private final String code;

}
