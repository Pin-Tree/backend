package com.trio.pintree.login.domain;

import lombok.Getter;

@Getter
public enum SocialPortal {
    GOOGLE("googleOauthService"),
    KAKAO("kakaoOauthService"),
    NAVER("naverOauthService");

    private String socialServiceName;

    SocialPortal(String socialServiceName) {
        this.socialServiceName = socialServiceName;
    }
}
