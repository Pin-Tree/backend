package com.trio.pintree.login.service;

import com.trio.pintree.login.domain.Member;
import com.trio.pintree.login.dto.AccessTokenResponse;
import org.springframework.stereotype.Service;

@Service
public class KakaoOauthService implements OauthService {

    @Override
    public AccessTokenResponse issueAccessToken(String... str) {
        return null;
    }

    @Override
    public Member getMemberFrom(AccessTokenResponse accessTokenResponse) {
        return null;
    }
}
