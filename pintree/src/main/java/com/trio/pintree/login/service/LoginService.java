package com.trio.pintree.login.service;

import com.trio.pintree.login.component.OauthServiceFactory;
import com.trio.pintree.login.dto.AccessTokenResponse;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Getter
@RequiredArgsConstructor
public class LoginService {
    private final OauthServiceFactory oauthServiceFactory;

    public AccessTokenResponse issueGoogleAccessToken(String code) {
        return oauthServiceFactory.dispatchGoogleAccessTokenRequest(code);
    }

    public AccessTokenResponse issueKakaoAccessToken(String code) {
        return oauthServiceFactory.dispatchKakaoAccessTokenRequest(code);
    }
}
