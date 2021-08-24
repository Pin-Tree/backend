package com.trio.pintree.login.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "oauth.naver")
public class NaverOauthProperties {

    private String clientId;
    private String clientSecret;
    private String grantType;
    private String accessTokenUrl;

}
