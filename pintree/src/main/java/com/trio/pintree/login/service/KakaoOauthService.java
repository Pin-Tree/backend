package com.trio.pintree.login.service;

import com.trio.pintree.login.domain.Member;
import com.trio.pintree.login.dto.AccessTokenResponse;
import com.trio.pintree.login.dto.KaKaoAccessTokenResponse;
import com.trio.pintree.login.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Slf4j
@Service
public class KakaoOauthService implements OauthService {

    private static final RestTemplate restTemplate = new RestTemplate();
    private final MemberRepository memberRepository;
    private final WebClient webClient;

    private final String ACCESS_TOKEN_URI;
    private final String GET_INFO_URL;
    private final String GRANT_TYPE;
    private final String REDIRECT_URL;
    private final String CLIENT_ID;
    private final String SECRET_KEY;
    private final MediaType CONTENT_TYPE = MediaType.APPLICATION_FORM_URLENCODED;

    public KakaoOauthService(MemberRepository memberRepository,
                             WebClient webClient,
                             @Value("${oauth.kakao.access.token.uri}") String accessTokenUri,
                             @Value("${oauth.kakao.get.info.uri}") String getInfoUrl,
                             @Value("${oauth.kakao.grant.type}") String grantType,
                             @Value("${oauth.kakao.redirect.uri}") String redirectUrl,
                             @Value("${oauth.kakao.client.id}") String clientId,
                             @Value("${oauth.kakao.secret.key}") String secretKey) {
        this.memberRepository = memberRepository;
        this.webClient = webClient;
        this.ACCESS_TOKEN_URI = accessTokenUri;
        this.GET_INFO_URL = getInfoUrl;
        this.GRANT_TYPE = grantType;
        this.REDIRECT_URL = redirectUrl;
        this.CLIENT_ID = clientId;
        this.SECRET_KEY = secretKey;
    }

    @Override
    public KaKaoAccessTokenResponse issueAccessToken(String... str) {

        final String code = str[0];

        // Request Body 오브젝트 생성
        MultiValueMap<String, String> bodies = new LinkedMultiValueMap<>();
        bodies.add("grant_type", GRANT_TYPE);
        bodies.add("client_id", CLIENT_ID);
        bodies.add("redirect_uri", REDIRECT_URL);
        bodies.add("code", code);
        bodies.add("client_secret", SECRET_KEY);

        // HttpHeader와 HttpBody를 하나의 오브젝트에 담기
        RequestEntity<MultiValueMap<String, String>> kakaoAccessTokenRequest = RequestEntity
                                                                                 .post(ACCESS_TOKEN_URI) // status line
                                                                                 .contentType(CONTENT_TYPE) // header
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
                        .uri(ACCESS_TOKEN_URI)
                        .contentType(CONTENT_TYPE)
                        .accept(CONTENT_TYPE)
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
