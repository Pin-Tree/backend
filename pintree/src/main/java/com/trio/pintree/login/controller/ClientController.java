package com.trio.pintree.login.controller;

import com.trio.pintree.login.properties.KaKaoClientProperties;
import com.trio.pintree.login.properties.NaverClientProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.security.NoSuchAlgorithmException;

@Slf4j
@Controller
@RequestMapping("/auth/social/redirect")
public class ClientController {

    private final NaverClientProperties naverClientProperties;
    private final KaKaoClientProperties kaKaoClientProperties;

    public ClientController(NaverClientProperties naverClientProperties, KaKaoClientProperties kaKaoClientProperties) {
        this.naverClientProperties = naverClientProperties;
        this.kaKaoClientProperties = kaKaoClientProperties;
    }

    @GetMapping("/naver")
    public String naverLogin(HttpSession session) {
        final String state = (String) session.getAttribute("state");

        log.debug("Client Id : {}", naverClientProperties.getClientId());
        log.debug("Response Type : {}", naverClientProperties.getResponseType());
        log.debug("Redirect URI: {}", naverClientProperties.getRedirectUri());
        log.debug("State : {}", state);

        return new StringBuilder("redirect:https://nid.naver.com/oauth2.0/authorize?")
                .append("client_id=").append(naverClientProperties.getClientId())
                .append("&response_type=").append(naverClientProperties.getResponseType())
                .append("&redirect_uri=").append(naverClientProperties.getRedirectUri())
                .append("&state=").append(state)
                .toString();
    }

    @GetMapping("/kakao")
    public String kakaoRedirect() {
        return "redirect:" + kaKaoClientProperties.getUrl();
    }
}
