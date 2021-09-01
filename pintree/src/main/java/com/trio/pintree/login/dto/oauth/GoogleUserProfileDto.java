package com.trio.pintree.login.dto.oauth;

import lombok.Getter;
import lombok.ToString;


@Getter
@ToString
public class GoogleUserProfileDto implements UserProfile {

    private String email;
    private String picture;

}
