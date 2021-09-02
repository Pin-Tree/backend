package com.trio.pintree.login.dto.oauth;

import lombok.Getter;
import lombok.ToString;


@Getter
@ToString
public class GoogleUserProfile implements UserProfile {

    private String email;
    private String picture;

    @Override
    public String getNickname() {
        return null;
    }
}
