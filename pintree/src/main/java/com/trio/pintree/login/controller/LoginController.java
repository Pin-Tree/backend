package com.trio.pintree.login.controller;

import com.trio.pintree.login.domain.SocialPortal;
import com.trio.pintree.login.dto.AuthRequest;
import com.trio.pintree.login.dto.JwtResponse;
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
    public ResponseEntity<JwtResponse> loginByGoogle(String code) {
        AuthRequest authRequest = AuthRequest.create(code);
        log.debug("code: {}", authRequest.getCode());

        JwtResponse jwtResponse = loginService.loginBySocialService(authRequest, SocialPortal.GOOGLE);
        log.debug("jwtResponse : {}", jwtResponse);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(jwtResponse);
    }

    @GetMapping("/kakao")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<JwtResponse> loginByKakao(String code) {
        AuthRequest authRequest = AuthRequest.create(code);
        log.debug("code: {}", code);

        JwtResponse jwtResponse = loginService.loginBySocialService(authRequest, SocialPortal.KAKAO);
        log.debug("jwtResponse : {}", jwtResponse);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(jwtResponse);
    }

    @GetMapping("/naver")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<JwtResponse> loginByNaver(String code, String state) {
        AuthRequest authRequest = AuthRequest.create(code, state);
        log.debug("code: {}", code);
        log.debug("state: {}", state);

        JwtResponse jwtResponse = loginService.loginBySocialService(authRequest, SocialPortal.NAVER);
        log.debug("jwtResponse : {}", jwtResponse);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(jwtResponse);
    }
}
