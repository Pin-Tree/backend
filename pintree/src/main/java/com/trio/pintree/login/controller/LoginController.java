package com.trio.pintree.login.controller;

import com.trio.pintree.login.dto.AuthRequest;
import com.trio.pintree.login.dto.oauth.AccessTokenResponse;
import com.trio.pintree.login.dto.oauth.UserProfile;
import com.trio.pintree.login.service.AuthService;
import com.trio.pintree.login.service.LoginService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/login")
public class LoginController {

    private final LoginService loginService;
    private final AuthService authService;

    @GetMapping("/google")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<UserProfile> getGoogleProfile(String code) {
        AuthRequest authRequest = AuthRequest.create(code);
        log.debug("code: {}", authRequest.getCode());

        UserProfile userProfile = loginService.getGoogleProfile(authRequest);
        log.debug("userProfile : {}", userProfile);

        return ResponseEntity.status(HttpStatus.OK).body(userProfile);
    }

    @GetMapping("/kakao")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<UserProfile> getKaKaoProfile(String code) {
        AuthRequest authRequest = AuthRequest.create(code);
        log.debug("code: {}", code);

        UserProfile userProfile = loginService.getKaKaoProfile(authRequest);

        return ResponseEntity.status(HttpStatus.CREATED).body(userProfile);
    }

    @GetMapping("/naver")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<AccessTokenResponse> getNaverProfile(String code, String state) {
        AuthRequest authRequest = AuthRequest.create(code, state);
        log.debug("code: {}", code);
        log.debug("state: {}", state);

        AccessTokenResponse accessTokenResponse = loginService.getNaverProfile(authRequest);

        return ResponseEntity.status(HttpStatus.CREATED).body(accessTokenResponse);
    }

}
