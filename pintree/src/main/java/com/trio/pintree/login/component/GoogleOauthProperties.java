package com.trio.pintree.login.component;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "oauth.google")
@Setter
@Getter
@ToString
public class GoogleOauthProperties {
    private String clientId;
    private String secretKey;
    private String accessTokenUri;
    private String redirectUri;
    private String grantType;
}
