package com.trio.pintree.login.service;

import com.trio.pintree.login.component.KaKaoOauthProperties;
import com.trio.pintree.login.domain.Member;
import com.trio.pintree.login.dto.AccessTokenResponse;
import com.trio.pintree.login.dto.KaKaoAccessTokenResponse;
import com.trio.pintree.login.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Slf4j
@Service
@RequiredArgsConstructor
public class KakaoOauthService implements OauthService {

    private static final RestTemplate restTemplate = new RestTemplate();
    private final MemberRepository memberRepository;
    private final WebClient webClient;
    private final KaKaoOauthProperties kaKaoOauthProperties;

    @Override
    public KaKaoAccessTokenResponse issueAccessToken(String... str) {

        final String code = str[0];

        MultiValueMap<String, String> bodies = new LinkedMultiValueMap<>();
        bodies.add("grant_type", kaKaoOauthProperties.getGrantType());
        bodies.add("client_id", kaKaoOauthProperties.getClientId());
        bodies.add("redirect_uri", kaKaoOauthProperties.getRedirectUri());
        bodies.add("code", code);
        bodies.add("client_secret", kaKaoOauthProperties.getSecretKey());

        RequestEntity<MultiValueMap<String, String>> kakaoAccessTokenRequest = RequestEntity
                .post(kaKaoOauthProperties.getAccessTokenUri()) // status line
                .contentType(MediaType.APPLICATION_FORM_URLENCODED) // header
                .body(bodies);
        log.debug("accessTokenRequest : {}", kakaoAccessTokenRequest);

        KaKaoAccessTokenResponse kaKaoAccessTokenResponse = sendRequestForAccessToken(kakaoAccessTokenRequest);

        log.debug("AccessToken : {}", kaKaoAccessTokenResponse.getAccessToken());

        return kaKaoAccessTokenResponse;
    }

    private KaKaoAccessTokenResponse sendRequestForAccessToken(RequestEntity<MultiValueMap<String, String>> kakaoAccessTokenRequest) {
        try {
            return restTemplate.exchange(
                    kakaoAccessTokenRequest,
                    KaKaoAccessTokenResponse.class
            ).getBody();
        } catch (Exception e) {
            throw new RuntimeException("엑세스 토큰 획득 실패 "+e.getMessage());
        }
    }

    // 동작 안하는 메서드
    private KaKaoAccessTokenResponse sendRequestForAccessToken_(RequestEntity<MultiValueMap<String, String>> kakaoAccessTokenRequest) {
        return webClient.mutate()
                .build()
                .post()
                .uri(kaKaoOauthProperties.getAccessTokenUri())
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .accept(MediaType.APPLICATION_FORM_URLENCODED)
                .bodyValue(kakaoAccessTokenRequest)
                .retrieve()
                .bodyToMono(KaKaoAccessTokenResponse.class)
                .blockOptional()
                .orElseThrow(RuntimeException::new);
    }

    @Override
    public Member getMemberFrom(AccessTokenResponse accessTokenResponse) {
        return null;
    }
}

