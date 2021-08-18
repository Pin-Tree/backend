package com.trio.pintree.login.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequestMapping("/api/auth")
public class RedirectController {

    final String kakaoUrl;

    public RedirectController(@Value("${oauth.kakao.url}") String kakaoUrl) {
        this.kakaoUrl = kakaoUrl;
    }

    @GetMapping("social/redirect/kakao")
    public String kakaoRedirect() {

        return "redirect:" + kakaoUrl;
    }

}
