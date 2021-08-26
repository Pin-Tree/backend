package com.trio.pintree.login.properties;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

@Getter
@ToString
@ConstructorBinding
@RequiredArgsConstructor
@ConfigurationProperties(prefix = "oauth.naver")
public class NaverOauthProperties {

    private final String clientId;
    private final String clientSecret;
    private final String grantType;
    private final String accessTokenUrl;

}
