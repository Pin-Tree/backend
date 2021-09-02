package com.trio.pintree.login.service;

import com.trio.pintree.login.domain.Member;
import com.trio.pintree.login.dto.AuthRequest;
import com.trio.pintree.login.dto.oauth.AccessTokenResponse;
import com.trio.pintree.login.dto.oauth.NaverAccessTokenResponse;
import com.trio.pintree.login.dto.oauth.NaverUserProfile;
import com.trio.pintree.login.dto.oauth.UserProfile;
import com.trio.pintree.login.properties.NaverOauthProperties;
import com.trio.pintree.login.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class NaverOauthService implements OauthService {

    private final MemberRepository memberRepository;
    private final WebClient webClient;
    private final NaverOauthProperties oauthProperties;

    @Override
    public AccessTokenResponse issueAccessToken(AuthRequest authRequest) {
        String uri = getAsUriParams(authRequest);

        AccessTokenResponse naverAccessTokenResponse = sendAccessTokenRequest(uri);
        log.debug("naverAccessTokenResponse : {}", naverAccessTokenResponse);

        return naverAccessTokenResponse;
    }

    private NaverAccessTokenResponse sendAccessTokenRequest(String uri) {
        return webClient.get()
                .uri(uri)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(NaverAccessTokenResponse.class)
                .blockOptional()
                .orElseThrow(RuntimeException::new);
    }

    private String getAsUriParams(AuthRequest authRequest){
        UriComponents builder = UriComponentsBuilder.fromHttpUrl(oauthProperties.getAccessTokenUrl())
                .queryParam("client_id", oauthProperties.getClientId())
                .queryParam("client_secret", oauthProperties.getClientSecret())
                .queryParam("grant_type", oauthProperties.getGrantType())
                .queryParam("state", authRequest.getStatus())
                .queryParam("code", authRequest.getCode())
                .build(false);

        return builder.toString();
    }

    @Override
    public UserProfile getMemberFrom(AccessTokenResponse accessTokenResponse) {
        return webClient.post()
                .uri("https://openapi.naver.com/v1/nid/me")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .header(HttpHeaders.AUTHORIZATION, "Bearer " + accessTokenResponse.getAccessToken())
                .retrieve()
                .bodyToMono(NaverUserProfile.class)
                .blockOptional()
                .orElseThrow(RuntimeException::new);
    }

    @Override
    public Member findMember(UserProfile userProfile) {
        Optional<Member> member = memberRepository.findByEmail(userProfile.getEmail());

        if (member.isPresent()) {
            return member.get();
        }

        Member newMember = Member.create(userProfile.getEmail(), userProfile.getNickname(), null);
        return memberRepository.save(newMember);
    }

}
