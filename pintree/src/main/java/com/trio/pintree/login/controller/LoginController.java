package com.trio.pintree.login.controller;

import com.trio.pintree.login.component.OauthServiceFactory;
import com.trio.pintree.login.domain.Member;
import com.trio.pintree.login.dto.AuthRequest;
import com.trio.pintree.login.dto.AuthResponse;
import com.trio.pintree.login.dto.KaKaoAccessTokenResponse;
import com.trio.pintree.login.service.KakaoOauthService;
import com.trio.pintree.login.service.LoginService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.CREATED;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/login")
public class LoginController {
    private final LoginService loginService;

    @GetMapping("/kakao")
    public ResponseEntity<AuthResponse> auth(@RequestBody AuthRequest authRequest) {
        String code = authRequest.getCode();

        OauthServiceFactory oauthServiceFactory = loginService.getOauthServiceFactory();
        KakaoOauthService kakaoOauthService = oauthServiceFactory.getKaKaoOauthService();

        KaKaoAccessTokenResponse accessTokenResponse = kakaoOauthService.issueAccessToken(code);

        //Member member = kakaoOauthService.getMemberFrom(accessTokenResponse);

        return ResponseEntity.status(CREATED)
                             .body(new AuthResponse(accessTokenResponse.getAccessToken()));
    }

}
