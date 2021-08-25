package com.trio.pintree.login.dto;

import lombok.Getter;

@Getter
public class JwtResponse {
    private static String DEFAULT_PROFILE_URL = "https://issue-tracker-img-storage.s3.ap-northeast-2.amazonaws.com/Screen+Shot+2021-08-25+at+4.28.33+PM.png";

    private final String jwt;
    private final String nickname;
    private final String profile;

    private JwtResponse(String jwt, String nickname, String profile) {
        this.jwt = jwt;
        this.nickname = nickname;
        this.profile = (profile != null) ? profile : DEFAULT_PROFILE_URL;
    }

    public static JwtResponse create(String jwt, String nickname, String profile){
        return new JwtResponse(jwt, nickname, profile);
    }
}
