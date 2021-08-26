package com.trio.pintree.login.service;

import com.trio.pintree.login.domain.Member;
import com.trio.pintree.login.dto.AuthRequest;
import com.trio.pintree.login.dto.oauth.AccessTokenResponse;

public interface OauthService {

    Member getMemberFrom(AccessTokenResponse accessTokenResponse);

    AccessTokenResponse issueAccessToken(AuthRequest authRequest);
}
