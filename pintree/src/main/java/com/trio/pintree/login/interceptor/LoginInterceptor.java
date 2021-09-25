package com.trio.pintree.login.interceptor;

import com.trio.pintree.login.annotation.LoginRequired;
import com.trio.pintree.login.domain.Member;
import com.trio.pintree.login.exception.AuthenticationException;
import com.trio.pintree.login.service.SessionService;
import com.trio.pintree.login.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;

@Slf4j
@Component
@RequiredArgsConstructor
public class LoginInterceptor implements HandlerInterceptor {
    private final SessionService sessionService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        if (isLoginRequired(handler)) {
            authenticate(request);
        }
        return true;
    }

    private boolean isLoginRequired(Object handler) {
        return handler instanceof HandlerMethod
                && ((HandlerMethod) handler).hasMethodAnnotation(LoginRequired.class);
    }

    private void authenticate(HttpServletRequest request) {
        String authorization = Optional.ofNullable(request.getHeader(AUTHORIZATION))
                .orElseThrow(() -> new AuthenticationException("인증되지 않은 유저입니다. Authorization 헤더를 포함해주세요."));
        String[] splitAuth = authorization.split(" ");
        String tokenType = splitAuth[0].toLowerCase();

        if (splitAuth.length < 2 || !tokenType.equals("bearer")) {
            throw new AuthenticationException("잘못된 Authorization 타입입니다. 토큰 앞에 Bearer 를 붙여주세요.");
        }

        String uuid = JwtUtil.decodeJwt(splitAuth[1]);
        Member findMember = sessionService.getMember(uuid);

        //TODO. toString()으로 할 것인지? getId()를 할 때 처음부터 String을 뱉어줄건지? 정하기
        request.setAttribute("uuid", findMember.getId().toString());
    }
}

