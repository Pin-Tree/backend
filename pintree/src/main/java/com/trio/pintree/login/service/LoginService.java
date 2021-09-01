package com.trio.pintree.login.service;

import com.trio.pintree.login.dto.AuthRequest;
import com.trio.pintree.login.dto.oauth.AccessTokenResponse;
import com.trio.pintree.login.dto.oauth.UserProfile;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;

@Service
@Getter
@RequiredArgsConstructor
public class LoginService {

    private final OauthServiceFactory oauthServiceFactory;

    //TODO. issueGoogleAccessToken 메서드명 네이밍 변경 필요함. (인터페이스도 찾아보자)
    public UserProfile getGoogleProfile(AuthRequest authRequest) {
        OauthService googleOauthService = oauthServiceFactory.getGoogleOauthService();
        AccessTokenResponse accessTokenResponse = googleOauthService.issueAccessToken(authRequest);
        return googleOauthService.getMemberFrom(accessTokenResponse);
    }

    public UserProfile getKaKaoProfile(AuthRequest authRequest) {
        OauthService kakaoOauthService = oauthServiceFactory.getKakaoOauthService();
        AccessTokenResponse accessTokenResponse = kakaoOauthService.issueAccessToken(authRequest);
        return kakaoOauthService.getMemberFrom(accessTokenResponse);
    }

    public AccessTokenResponse getNaverProfile(AuthRequest authRequest) {
        OauthService naverOauthService = oauthServiceFactory.getNaverOauthService();
        return naverOauthService.issueAccessToken(authRequest);
    }

}
