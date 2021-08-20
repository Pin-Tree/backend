package com.trio.pintree.login.controller;

import com.trio.pintree.login.dto.AccessTokenResponse;
import com.trio.pintree.login.dto.AuthResponse;
import com.trio.pintree.login.service.LoginService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.trio.pintree.login.component.OauthServiceFactory;

import static org.springframework.http.HttpStatus.CREATED;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/login")
public class LoginController {
    private final LoginService loginService;

    @GetMapping("/google")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<AccessTokenResponse> issueGoogleAccessToken(String code) {
        log.debug("code: {}", code);

        AccessTokenResponse accessTokenResponse = loginService.issueGoogleAccessToken(code);

        log.debug("accessTokenResponse : {}", accessTokenResponse);

        return ResponseEntity.ok(accessTokenResponse);
    }

    @GetMapping("/kakao")
    public ResponseEntity<AccessTokenResponse> issueAccessToken(String code) {
        AccessTokenResponse accessTokenResponse = loginService.issueKakaoAccessToken(code);
        return ResponseEntity.status(CREATED).body(accessTokenResponse);
    }
}
