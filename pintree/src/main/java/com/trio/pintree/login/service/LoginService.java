package com.trio.pintree.login.service;

import com.trio.pintree.login.component.OauthServiceFactory;
import com.trio.pintree.login.dto.AccessTokenResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService {
    private final OauthServiceFactory oauthServiceFactory;

    public AccessTokenResponse issueNaverAccessToken(String code, String state) {
        OauthService oauthService = oauthServiceFactory.getNaverOauthService();
        AccessTokenResponse accessTokenResponse = oauthService.issueAccessToken(code, state);
        return accessTokenResponse;
    }
}
