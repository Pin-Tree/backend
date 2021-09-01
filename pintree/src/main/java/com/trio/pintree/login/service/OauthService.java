package com.trio.pintree.login.service;

import com.trio.pintree.login.dto.AuthRequest;
import com.trio.pintree.login.dto.oauth.AccessTokenResponse;
import com.trio.pintree.login.dto.oauth.UserProfile;

public interface OauthService {

    UserProfile getMemberFrom(AccessTokenResponse accessTokenResponse);

    AccessTokenResponse issueAccessToken(AuthRequest authRequest);
}