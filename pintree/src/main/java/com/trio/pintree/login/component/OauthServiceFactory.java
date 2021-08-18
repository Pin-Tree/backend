package com.trio.pintree.login.component;

import com.trio.pintree.login.service.OauthService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@RequiredArgsConstructor
public class OauthServiceFactory {
    private final Map<String, OauthService> oauthServiceMap;
}
