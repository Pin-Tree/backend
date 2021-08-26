package com.trio.pintree.login.service;

import com.trio.pintree.login.domain.Member;
import com.trio.pintree.login.dto.oauth.AccessTokenResponse;

public interface OauthService {

    AccessTokenResponse issueAccessToken(String... str);

    Member getMemberFrom(AccessTokenResponse accessTokenResponse);

}
