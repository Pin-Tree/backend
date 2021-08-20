package com.trio.pintree.login.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
@ConfigurationProperties("oauth.kakao")
public class KaKaoOauthProperties {
    private String clientId;
    private String secretKey;
    private String accessTokenUri;
    private String redirectUri;
    private String grantType;
    private String userInfo;
}
