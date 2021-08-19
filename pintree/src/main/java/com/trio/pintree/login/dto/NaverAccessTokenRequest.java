package com.trio.pintree.login.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@Getter
@RequiredArgsConstructor(staticName = "create")
public class NaverAccessTokenRequest {

    @JsonProperty("client_id")
    private final String clientId;

    @JsonProperty("client_secret")
    private final String clientSecret;

    @JsonProperty("grant_type")
    private final String grantType;

    private final String state;

    private final String code;

    public String getAsUriParams(final String url){
        UriComponents builder = UriComponentsBuilder.fromHttpUrl(url)
                .queryParam("client_id", clientId)
                .queryParam("client_secret", clientSecret)
                .queryParam("grant_type", grantType)
                .queryParam("state", state)
                .queryParam("code", code)
                .build(false);

        return builder.toString();
    }

}

