package com.trio.pintree.login.properties;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

@ConstructorBinding
@ConfigurationProperties(prefix = "oauth.google")
@Getter
@ToString
@RequiredArgsConstructor
public class GoogleOauthProperties {
    private final String clientId;
    private final String secretKey;
    private final String accessTokenUri;
    private final String redirectUri;
    private final String grantType;
}
