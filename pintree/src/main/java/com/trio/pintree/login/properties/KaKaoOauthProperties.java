package com.trio.pintree.login.properties;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@ConstructorBinding
@ConfigurationProperties(prefix = "oauth.kakao")
@Getter
@ToString
@RequiredArgsConstructor
public class KaKaoOauthProperties {
    private final String clientId;
    private final String secretKey;
    private final String accessTokenUri;
    private final String redirectUri;
    private final String grantType;
    private final String userInfo;
}
