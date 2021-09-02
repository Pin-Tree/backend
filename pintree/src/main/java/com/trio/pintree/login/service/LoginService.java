package com.trio.pintree.login.service;

import com.trio.pintree.login.domain.Member;
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

    public JwtResponse loginByGoogleAuth(AuthRequest authRequest) {
        OauthService googleOauthService = oauthServiceFactory.getGoogleOauthService();
        UserProfile googleProfile = getGoogleProfile(authRequest);
        return getJwtResponse(googleOauthService, googleProfile);
    }

    public JwtResponse loginByKakaoAuth(AuthRequest authRequest) {
        OauthService kakaoOauthService = oauthServiceFactory.getKakaoOauthService();
        UserProfile kakaoProfile = getKaKaoProfile(authRequest);
        return getJwtResponse(kakaoOauthService, kakaoProfile);
    }

    public JwtResponse loginByNaverAuth(AuthRequest authRequest) {
        OauthService naverOauthService = oauthServiceFactory.getNaverOauthService();
        UserProfile naverProfile = getNaverProfile(authRequest);
        return getJwtResponse(naverOauthService, naverProfile);
    }


    public UserProfile getGoogleProfile(AuthRequest authRequest) {
        OauthService googleOauthService = oauthServiceFactory.getGoogleOauthService();
        AccessTokenResponse accessTokenResponse = googleOauthService.issueAccessToken(authRequest);
        return googleOauthService.getMemberFrom(accessTokenResponse);
    }

    public UserProfile getKaKaoProfile(AuthRequest authRequest) {
        OauthService kakaoOauthService = oauthServiceFactory.getKakaoOauthService();
        AccessTokenResponse accessTokenResponse = kakaoOauthService.issueAccessToken(authRequest);
        return kakaoOauthService.getMemberFrom(accessTokenResponse);
    }

    public UserProfile getNaverProfile(AuthRequest authRequest) {
        OauthService naverOauthService = oauthServiceFactory.getNaverOauthService();
        AccessTokenResponse accessTokenResponse = naverOauthService.issueAccessToken(authRequest);
        return naverOauthService.getMemberFrom(accessTokenResponse);
    }

    private JwtResponse getJwtResponse(OauthService oauthService, UserProfile userProfile) {
        Member member = oauthService.findMember(userProfile);
        MemberResponseDto memberResponse = MemberResponseDto.fromEntity(member);

        String jwt = JwtUtil.createJwt(member.getId().toString());
        return JwtResponse.create(jwt, memberResponse);
    }

}
