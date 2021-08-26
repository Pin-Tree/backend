package com.trio.pintree.login.properties;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

@ConstructorBinding
@ConfigurationProperties(prefix = "oauth.kakao.client")
@Getter
@ToString
@RequiredArgsConstructor
public class KaKaoClientProperties {
    private final String url;
}
