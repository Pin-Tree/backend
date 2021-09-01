package com.trio.pintree.login.config;

import com.trio.pintree.login.interceptor.NaverOauthInterceptor;
import com.trio.pintree.login.interceptor.LoginInterceptor;
import com.trio.pintree.login.interceptor.RequestInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class OauthConfig implements WebMvcConfigurer {

    private final NaverOauthInterceptor naverOauthInterceptor;
    private final LoginInterceptor loginInterceptor;

    public OauthConfig(NaverOauthInterceptor naverOauthInterceptor, LoginInterceptor loginInterceptor) {
        this.naverOauthInterceptor = naverOauthInterceptor;
        this.loginInterceptor = loginInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(naverOauthInterceptor)
                .addPathPatterns("/login/naver");

        registry.addInterceptor(loginInterceptor)
                .addPathPatterns("/api/login/google")
                .addPathPatterns("/api/login/naver")
                .addPathPatterns("/api/login/kakao");
    }

}

