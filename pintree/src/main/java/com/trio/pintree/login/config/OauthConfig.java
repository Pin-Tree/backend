package com.trio.pintree.login.config;

import com.trio.pintree.login.interceptor.NaverOauthInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class OauthConfig implements WebMvcConfigurer {

    private final NaverOauthInterceptor naverOauthInterceptor;

    public OauthConfig(NaverOauthInterceptor naverOauthInterceptor) {
        this.naverOauthInterceptor = naverOauthInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(naverOauthInterceptor)
                .addPathPatterns("/auth/social/redirect/naver");
    }

}

