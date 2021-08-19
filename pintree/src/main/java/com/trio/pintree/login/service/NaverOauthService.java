package com.trio.pintree.login.service;

import com.trio.pintree.login.component.NaverOauthProperties;
import com.trio.pintree.login.domain.Member;
import com.trio.pintree.login.dto.AccessTokenResponse;
import com.trio.pintree.login.dto.NaverAccessTokenResponse;
import com.trio.pintree.login.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@RequiredArgsConstructor
public class NaverOauthService implements OauthService {

    private final NaverOauthProperties oauthProperties;
    private final MemberRepository memberRepository;
    private final WebClient webClient;

    @Override
    public AccessTokenResponse issueAccessToken(String... str) {
        String code = str[0];
        String state = str[1];

        String uri = oauthProperties.getAsUriParams(code, state);

        return webClient.get()
                .uri(uri)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(NaverAccessTokenResponse.class)
                .blockOptional()
                .orElseThrow(RuntimeException::new);
    }

    @Override
    public Member getMemberFrom(AccessTokenResponse accessTokenResponse) {
        return null;
    }
}
