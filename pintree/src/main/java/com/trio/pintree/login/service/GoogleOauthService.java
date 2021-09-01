package com.trio.pintree.login.service;

import com.trio.pintree.login.dto.AuthRequest;
import com.trio.pintree.login.dto.oauth.AccessTokenResponse;
import com.trio.pintree.login.dto.oauth.GoogleAccessTokenRequest;
import com.trio.pintree.login.dto.oauth.GoogleAccessTokenResponse;
import com.trio.pintree.login.dto.oauth.UserProfile;
import com.trio.pintree.login.properties.GoogleOauthProperties;
import com.trio.pintree.login.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@RequiredArgsConstructor
@Slf4j
public class GoogleOauthService implements OauthService {

    private final MemberRepository memberRepository;
    private final WebClient webClient;
    private final GoogleOauthProperties googleOauthProperties;

    @Override
    public AccessTokenResponse issueAccessToken(AuthRequest authRequest) {
        String code = authRequest.getCode();

        GoogleAccessTokenRequest googleAccessTokenRequest = generateGoogleAccessTokenRequest(code);
        log.debug("googleAccessTokenRequest : {}", googleAccessTokenRequest);

        AccessTokenResponse googleAccessTokenResponse = sendAccessTokenRequest(googleAccessTokenRequest);
        log.debug("googleAccessTokenResponse : {}", googleAccessTokenResponse);

        return googleAccessTokenResponse;
    }

    private GoogleAccessTokenRequest generateGoogleAccessTokenRequest(String code) {
        return GoogleAccessTokenRequest.builder()
                .clientId(googleOauthProperties.getClientId())
                .clientSecret(googleOauthProperties.getSecretKey())
                .redirectUri(googleOauthProperties.getRedirectUri())
                .code(code)
                .grantType(googleOauthProperties.getGrantType())
                .build();
    }

    private AccessTokenResponse sendAccessTokenRequest(GoogleAccessTokenRequest googleAccessTokenRequest) {
        return webClient.post()
                .uri(googleOauthProperties.getAccessTokenUri())
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .bodyValue(googleAccessTokenRequest)
                .retrieve()
                .bodyToMono(GoogleAccessTokenResponse.class)
                .blockOptional()
                .orElseThrow(RuntimeException::new);
    }

    @Override
    public UserProfile getMemberFrom(AccessTokenResponse accessTokenResponse) {
        return null;
    }

}
