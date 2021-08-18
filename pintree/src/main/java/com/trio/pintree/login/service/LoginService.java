package com.trio.pintree.login.service;

import com.trio.pintree.login.component.OauthServiceFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService {
    private final OauthServiceFactory oauthServiceFactory;
}
