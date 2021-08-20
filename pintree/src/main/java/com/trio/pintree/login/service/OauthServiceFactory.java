package com.trio.pintree.login.service;

import com.trio.pintree.login.dto.AccessTokenResponse;
import com.trio.pintree.login.service.OauthService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Map;

@Slf4j
@Component
@RequiredArgsConstructor
public class OauthServiceFactory {
    private final Map<String, OauthService> oauthServiceMap;

    public AccessTokenResponse dispatchGoogleAccessTokenRequest(String code) {
        return oauthServiceMap.get("googleOauthService")
                .issueAccessToken(code);
    }

    public AccessTokenResponse dispatchKakaoAccessTokenRequest(String code) {
        return oauthServiceMap.get("kakaoOauthService").issueAccessToken(code);
    }
}
