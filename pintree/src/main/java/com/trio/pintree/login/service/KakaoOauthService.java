package com.trio.pintree.login.service;

import com.trio.pintree.login.properties.KaKaoOauthProperties;
import com.trio.pintree.login.domain.Member;
import com.trio.pintree.login.dto.AccessTokenResponse;
import com.trio.pintree.login.dto.KaKaoAccessTokenResponse;
import com.trio.pintree.login.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.client.WebClient;

@Slf4j
@Service
@RequiredArgsConstructor
public class KakaoOauthService implements OauthService {

    private final MemberRepository memberRepository;
    private final WebClient webClient;
    private final KaKaoOauthProperties kaKaoOauthProperties;

    @Override
    public KaKaoAccessTokenResponse issueAccessToken(String... str) {
        final String code = str[0];

        MultiValueMap<String, String> kakaoAccessTokenRequest = generateAccessTokenRequest(code);

        log.debug("accessTokenRequest : {}", kakaoAccessTokenRequest);

        KaKaoAccessTokenResponse kaKaoAccessTokenResponse = sendRequestForAccessToken(kakaoAccessTokenRequest);

        log.debug("kaKaoAccessTokenResponse : {}", kaKaoAccessTokenResponse);

        return kaKaoAccessTokenResponse;
    }

    private KaKaoAccessTokenResponse sendRequestForAccessToken(MultiValueMap<String, String> kakaoAccessTokenRequest) {
        return webClient.post()
                .uri(kaKaoOauthProperties.getAccessTokenUri())
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .accept(MediaType.APPLICATION_JSON)
                .bodyValue(kakaoAccessTokenRequest)
                .retrieve()
                .bodyToMono(KaKaoAccessTokenResponse.class)
                .blockOptional()
                .orElseThrow(RuntimeException::new);
    }

    private MultiValueMap<String, String> generateAccessTokenRequest(String code) {
        MultiValueMap<String, String> accessTokenRequestMap = new LinkedMultiValueMap<>();

        accessTokenRequestMap.add("grant_type", kaKaoOauthProperties.getGrantType());
        accessTokenRequestMap.add("client_id", kaKaoOauthProperties.getClientId());
        accessTokenRequestMap.add("redirect_uri", kaKaoOauthProperties.getRedirectUri());
        accessTokenRequestMap.add("code", code);
        accessTokenRequestMap.add("client_secret", kaKaoOauthProperties.getSecretKey());

        return accessTokenRequestMap;
    }

    @Override
    public Member getMemberFrom(AccessTokenResponse accessTokenResponse) {
        return null;
    }
}

