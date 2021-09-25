package com.trio.pintree.login.controller;

import com.trio.pintree.login.annotation.LoginRequired;
import com.trio.pintree.login.dto.AuthRequest;
import com.trio.pintree.login.dto.JwtResponse;
import com.trio.pintree.login.service.SessionService;
import com.trio.pintree.login.service.LoginService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/login")
public class LoginController {

    private final LoginService loginService;
    private final SessionService sessionService;

    @GetMapping("/google")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<JwtResponse> loginByGoogle(String code) {
        AuthRequest authRequest = AuthRequest.create(code);
        log.debug("code: {}", authRequest.getCode());

        JwtResponse jwtResponse = loginService.loginByGoogleAuth(authRequest);
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

        JwtResponse jwtResponse = loginService.loginByKakaoAuth(authRequest);
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

        JwtResponse jwtResponse = loginService.loginByNaverAuth(authRequest);
        log.debug("jwtResponse : {}", jwtResponse);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(jwtResponse);
    }

    @LoginRequired
    @GetMapping("/logout")
    @ResponseStatus(HttpStatus.OK)
    public void logout(HttpServletRequest request){
        sessionService.logout((String)request.getAttribute("uuid"));
    }
}
