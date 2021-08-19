package com.trio.pintree.login.component;

import com.trio.pintree.login.dto.NaverAccessTokenRequest;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@Data
@Component
@ConfigurationProperties(prefix = "oauth.naver")
public class NaverOauthProperties {

    private String clientId;
    private String clientSecret;
    private String grantType;
    private String accessTokenUrl;

    public NaverAccessTokenRequest tokenRequest(String code, String state){
        return NaverAccessTokenRequest
                .create(
                        clientId,
                        clientSecret,
                        grantType,
                        state,
                        code
                );
    }

    public String getAsUriParams(String code, String state){
        UriComponents builder = UriComponentsBuilder.fromHttpUrl(accessTokenUrl)
                .queryParam("client_id", clientId)
                .queryParam("client_secret", clientSecret)
                .queryParam("grant_type", grantType)
                .queryParam("state", state)
                .queryParam("code", code)
                .build(false);

        return builder.toString();
    }

}
