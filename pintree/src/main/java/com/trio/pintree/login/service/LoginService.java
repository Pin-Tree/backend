package com.trio.pintree.login.service;

import com.trio.pintree.login.domain.Member;
import com.trio.pintree.login.domain.SocialPortal;
import com.trio.pintree.login.dto.AuthRequest;
import com.trio.pintree.login.dto.JwtResponse;
import com.trio.pintree.login.dto.MemberResponseDto;
import com.trio.pintree.login.dto.oauth.AccessTokenResponse;
import com.trio.pintree.login.dto.oauth.UserProfile;
import com.trio.pintree.login.util.JwtUtil;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Getter
@RequiredArgsConstructor
public class LoginService {

    private final OauthServiceFactory oauthServiceFactory;

    public JwtResponse loginBySocialService(AuthRequest authRequest, SocialPortal social) {
        OauthService oauthService = oauthServiceFactory.getOauthService(social.getSocialServiceName());
        UserProfile profile = getUserProfile(oauthService, authRequest);
        return getJwtResponse(oauthService, profile);
    }

    private <T extends OauthService> UserProfile getUserProfile(T oauthService, AuthRequest authRequest){
        AccessTokenResponse accessTokenResponse = oauthService.issueAccessToken(authRequest);
        return oauthService.getMemberFrom(accessTokenResponse);
    }

    private <T extends OauthService> JwtResponse getJwtResponse(T oauthService, UserProfile userProfile) {
        Member member = oauthService.findMember(userProfile);
        MemberResponseDto memberResponse = MemberResponseDto.fromEntity(member);

        String jwt = JwtUtil.createJwt(member.getId().toString());
        return JwtResponse.create(jwt, memberResponse);
    }

}
