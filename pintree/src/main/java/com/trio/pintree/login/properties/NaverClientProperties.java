package com.trio.pintree.login.properties;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

@ConstructorBinding
@ConfigurationProperties(prefix = "oauth.naver")
@Getter
@ToString
@RequiredArgsConstructor
public class NaverClientProperties {
    private final String clientId;
    private final String responseType;
    private final String redirectUri;

}
