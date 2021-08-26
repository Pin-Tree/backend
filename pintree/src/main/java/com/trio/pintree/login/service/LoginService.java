package com.trio.pintree.login.service;

import com.trio.pintree.login.dto.oauth.AccessTokenResponse;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Getter
@RequiredArgsConstructor
public class LoginService {

    private final OauthServiceFactory oauthServiceFactory;

    public AccessTokenResponse issueGoogleAccessToken(String code) {
        OauthService googleOauthService = oauthServiceFactory.getGoogleOauthService();
        return googleOauthService.issueAccessToken(code);
    }

    public AccessTokenResponse issueKakaoAccessToken(String code) {
        OauthService kakaoOauthService = oauthServiceFactory.getKakaoOauthService();
        return kakaoOauthService.issueAccessToken(code);
    }

    public AccessTokenResponse issueNaverAccessToken(String code, String state) {
        OauthService naverOauthService = oauthServiceFactory.getNaverOauthService();
        return naverOauthService.issueAccessToken(code, state);
    }

}
