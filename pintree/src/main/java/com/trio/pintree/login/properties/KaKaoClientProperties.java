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
@ConfigurationProperties(prefix = "oauth.kakao.client")
public class KaKaoClientProperties {

    private final String url;

}
