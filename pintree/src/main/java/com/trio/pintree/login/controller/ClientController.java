package com.trio.pintree.login.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.security.NoSuchAlgorithmException;

@Slf4j
@Controller
@RequestMapping("/login")
public class ClientController {

    private final String clientId;
    private final String responseType;
    private final String redirectUri;

    public ClientController(@Value("${oauth.naver.clientId}") String clientId,
                            @Value("${oauth.naver.responseType}") String responseType,
                            @Value("${oauth.naver.redirectionUri}") String redirectUri) throws NoSuchAlgorithmException {

        this.clientId = clientId;
        this.responseType = responseType;
        this.redirectUri = redirectUri;
    }

    @GetMapping("/naver")
    public String naverLogin(HttpSession session) {
        final String state = (String) session.getAttribute("state");

        log.debug("Client Id : {}", clientId);
        log.debug("Response Type : {}", responseType);
        log.debug("Redirect URI: {}", redirectUri);
        log.debug("State : {}", state);

        return new StringBuilder("redirect:https://nid.naver.com/oauth2.0/authorize?")
                .append("client_id=").append(clientId)
                .append("&response_type=").append(responseType)
                .append("&redirect_uri=").append(redirectUri)
                .append("&state=").append(state)
                .toString();
    }
}
