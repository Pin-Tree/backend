package com.trio.pintree.login.service;

import com.trio.pintree.login.component.OauthServiceFactory;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Getter
@RequiredArgsConstructor
public class LoginService {
    private final OauthServiceFactory oauthServiceFactory;
}
