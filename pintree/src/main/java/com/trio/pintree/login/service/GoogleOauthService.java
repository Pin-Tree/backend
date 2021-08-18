package com.trio.pintree.login.service;

import com.trio.pintree.login.domain.Member;
import com.trio.pintree.login.dto.AccessTokenResponse;
import com.trio.pintree.login.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GoogleOauthService implements OauthService {

    private final MemberRepository memberRepository;

    @Override
    public AccessTokenResponse issueAccessToken(String... str) {
        return null;
    }

    @Override
    public Member getMemberFrom(AccessTokenResponse accessTokenResponse) {
        return null;
    }
}
