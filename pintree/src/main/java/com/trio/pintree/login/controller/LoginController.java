package com.trio.pintree.login.controller;

import com.trio.pintree.login.dto.AccessTokenResponse;
import com.trio.pintree.login.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/login")
public class LoginController {
    private final LoginService loginService;

    @GetMapping("/naver")
    public ResponseEntity<AccessTokenResponse> issueNaverAccessToken(final String code, final String state) {
        final AccessTokenResponse response = loginService.issueNaverAccessToken(code, state);
        return ResponseEntity.ok().body(response);
    }
}
