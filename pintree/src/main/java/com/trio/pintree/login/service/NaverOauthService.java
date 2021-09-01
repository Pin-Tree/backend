package com.trio.pintree.login.service;

import com.trio.pintree.login.dto.AuthRequest;
import com.trio.pintree.login.dto.oauth.AccessTokenResponse;
import com.trio.pintree.login.dto.oauth.NaverAccessTokenResponse;
import com.trio.pintree.login.dto.oauth.UserProfile;
import com.trio.pintree.login.properties.NaverOauthProperties;
import com.trio.pintree.login.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@Service
@RequiredArgsConstructor
public class NaverOauthService implements OauthService {

    private final MemberRepository memberRepository;
    private final WebClient webClient;
    private final NaverOauthProperties oauthProperties;

    @Override
    public AccessTokenResponse issueAccessToken(AuthRequest authRequest) {
        String code = authRequest.getCode();
        String state = authRequest.getCode();

        String uri = getAsUriParams(code, state);

        return webClient.get()
                .uri(uri)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(NaverAccessTokenResponse.class)
                .blockOptional()
                .orElseThrow(RuntimeException::new);

    }

    private String getAsUriParams(String code, String state){
        UriComponents builder = UriComponentsBuilder.fromHttpUrl(oauthProperties.getAccessTokenUrl())
                .queryParam("client_id", oauthProperties.getClientId())
                .queryParam("client_secret", oauthProperties.getClientSecret())
                .queryParam("grant_type", oauthProperties.getGrantType())
                .queryParam("state", state)
                .queryParam("code", code)
                .build(false);

        return builder.toString();
    }

    @Override
    public UserProfile getMemberFrom(AccessTokenResponse accessTokenResponse) {
        return null;
    }

}
