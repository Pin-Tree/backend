package com.trio.pintree.login.service;

import com.trio.pintree.login.domain.Member;
import com.trio.pintree.login.dto.AuthRequest;
import com.trio.pintree.login.dto.oauth.*;
import com.trio.pintree.login.properties.GoogleOauthProperties;
import com.trio.pintree.login.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Optional;

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
        return webClient.get()
                .uri("https://www.googleapis.com/oauth2/v1/userinfo")
                .header(HttpHeaders.AUTHORIZATION, "Bearer " + accessTokenResponse.getAccessToken())
                .retrieve()
                .bodyToMono(GoogleUserProfile.class)
                .blockOptional()
                .orElseThrow(RuntimeException::new);
    }

    @Override
    public Member findMember(UserProfile userProfile) {
        Optional<Member> member = memberRepository.findByEmail(userProfile.getEmail());

        if (member.isPresent()) {
            return member.get();
        }

        Member newMember = Member.create(userProfile.getEmail(), null, userProfile.getNickname());
        return memberRepository.save(newMember);
    }

}
