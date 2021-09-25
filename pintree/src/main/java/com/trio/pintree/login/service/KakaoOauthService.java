package com.trio.pintree.login.service;

import com.trio.pintree.login.dto.AuthRequest;
import com.trio.pintree.login.dto.oauth.AccessTokenResponse;
import com.trio.pintree.login.dto.oauth.KaKaoAccessTokenResponse;
import com.trio.pintree.login.dto.oauth.KaKaoUserProfile;
import com.trio.pintree.login.dto.oauth.UserProfile;
import com.trio.pintree.login.properties.KaKaoOauthProperties;
import com.trio.pintree.login.repository.MemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.client.WebClient;

@Slf4j
@Service
public class KakaoOauthService extends OauthService {

    private final WebClient webClient;
    private final KaKaoOauthProperties kaKaoOauthProperties;

    public KakaoOauthService(MemberRepository memberRepository,
                             SessionService sessionService,
                             WebClient webClient,
                             KaKaoOauthProperties kaKaoOauthProperties) {
        super(memberRepository, sessionService);
        this.webClient = webClient;
        this.kaKaoOauthProperties = kaKaoOauthProperties;
    }

    @Override
    public AccessTokenResponse issueAccessToken(AuthRequest authRequest) {
        final String code = authRequest.getCode();

        MultiValueMap<String, String> kakaoAccessTokenRequest = generateKakaoAccessTokenRequest(code);
        log.debug("kakaoAccessTokenRequest : {}", kakaoAccessTokenRequest);

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

    private MultiValueMap<String, String> generateKakaoAccessTokenRequest(String code) {
        MultiValueMap<String, String> accessTokenRequestMap = new LinkedMultiValueMap<>();

        accessTokenRequestMap.add("grant_type", kaKaoOauthProperties.getGrantType());
        accessTokenRequestMap.add("client_id", kaKaoOauthProperties.getClientId());
        accessTokenRequestMap.add("redirect_uri", kaKaoOauthProperties.getRedirectUri());
        accessTokenRequestMap.add("code", code);
        accessTokenRequestMap.add("client_secret", kaKaoOauthProperties.getSecretKey());

        return accessTokenRequestMap;
    }

    @Override
    public UserProfile getMemberFrom(AccessTokenResponse accessTokenResponse) {
        // Request Body 오브젝트 생성
        MultiValueMap<String, String> bodies = new LinkedMultiValueMap<>();

        //TODO. 멀티밸류인데 왜 따로따로 add 해서 하는건 파싱을 정상적으로 못하는지 아직 잘모르겠음. 다음에 트러블슈팅 해보자!
        bodies.add("property_keys", "[\"properties.nickname\", \"kakao_account.email\"]");

        return webClient.post()
                .uri(kaKaoOauthProperties.getUserInfo())
                .header("Authorization", "Bearer " + accessTokenResponse.getAccessToken())
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .bodyValue(bodies)
                .retrieve()
                .bodyToMono(KaKaoUserProfile.class)
                .blockOptional()
                .orElseThrow(RuntimeException::new);
    }


}

