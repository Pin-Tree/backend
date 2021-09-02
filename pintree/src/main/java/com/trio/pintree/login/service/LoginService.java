package com.trio.pintree.login.service;

import com.trio.pintree.login.domain.Member;
import com.trio.pintree.login.dto.AuthRequest;
import com.trio.pintree.login.dto.JwtResponse;
import com.trio.pintree.login.dto.MemberResponseDto;
import com.trio.pintree.login.dto.oauth.AccessTokenResponse;
import com.trio.pintree.login.dto.oauth.UserProfile;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;

@Service
@Getter
@RequiredArgsConstructor
public class LoginService {

    private final OauthServiceFactory oauthServiceFactory;

    public MemberResponseDto loginByGoogleAuth(AuthRequest authRequest) {
        OauthService googleOauthService = oauthServiceFactory.getGoogleOauthService();
        UserProfile googleProfile = getGoogleProfile(authRequest);
        Member member = googleOauthService.findMember(googleProfile);
        return MemberResponseDto.fromEntity(member);
    }

    public MemberResponseDto loginByKakaoAuth(AuthRequest authRequest) {
        OauthService kakaoOauthService = oauthServiceFactory.getKakaoOauthService();
        UserProfile kakaoProfile = getKaKaoProfile(authRequest);
        Member member = kakaoOauthService.findMember(kakaoProfile);
        return MemberResponseDto.fromEntity(member);
    }

    public MemberResponseDto loginByNaverAuth(AuthRequest authRequest) {
        OauthService naverOauthService = oauthServiceFactory.getNaverOauthService();
        UserProfile naverProfile = getNaverProfile(authRequest);
        Member member = naverOauthService.findMember(naverProfile);
        return MemberResponseDto.fromEntity(member);
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

}
