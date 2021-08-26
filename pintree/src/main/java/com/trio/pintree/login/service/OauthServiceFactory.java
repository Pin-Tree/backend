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

    public OauthService getGoogleOauthService() {
        return oauthServiceMap.get("googleOauthService");
    }

    public OauthService getKakaoOauthService() {
        return oauthServiceMap.get("kakaoOauthService");
    }

    public OauthService getNaverOauthService() {
        return oauthServiceMap.get("naverOauthService");
    }
}
