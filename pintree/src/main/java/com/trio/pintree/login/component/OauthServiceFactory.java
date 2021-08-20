package com.trio.pintree.login.component;

import com.trio.pintree.login.service.KakaoOauthService;
import com.trio.pintree.login.service.OauthService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Map;

@Slf4j
@Component
@RequiredArgsConstructor
public class OauthServiceFactory {
    private final static String KAKAO_OAUTH_SERVICE_NAME = "kakaoOauthService";
    private final Map<String, OauthService> oauthServiceMap;

    public KakaoOauthService getKaKaoOauthService() {
        return (KakaoOauthService) oauthServiceMap.get(KAKAO_OAUTH_SERVICE_NAME);
    }
}
