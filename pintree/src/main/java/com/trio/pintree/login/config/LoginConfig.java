package com.trio.pintree.login.config;

import com.trio.pintree.login.interceptor.LoginInterceptor;
import com.trio.pintree.login.service.SessionService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@RequiredArgsConstructor
public class LoginConfig implements WebMvcConfigurer {
    private final SessionService sessionService;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor(sessionService))
                .addPathPatterns("/api/login/logout");
    }

}