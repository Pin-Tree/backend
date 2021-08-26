package com.trio.pintree.login.service;

import com.trio.pintree.login.dto.AuthRequest;
import com.trio.pintree.login.dto.oauth.AccessTokenResponse;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Getter
@RequiredArgsConstructor
public class LoginService {

    private final OauthServiceFactory oauthServiceFactory;

    public AccessTokenResponse issueGoogleAccessToken(AuthRequest authRequest) {
        OauthService googleOauthService = oauthServiceFactory.getGoogleOauthService();
        return googleOauthService.issueAccessToken(authRequest);
    }
    public AccessTokenResponse issueKakaoAccessToken(AuthRequest authRequest) {
        OauthService kakaoOauthService = oauthServiceFactory.getKakaoOauthService();
        return kakaoOauthService.issueAccessToken(authRequest);
    }

    public AccessTokenResponse issueNaverAccessToken(AuthRequest authRequest) {
        OauthService naverOauthService = oauthServiceFactory.getNaverOauthService();
        return naverOauthService.issueAccessToken(authRequest);
    }

}
