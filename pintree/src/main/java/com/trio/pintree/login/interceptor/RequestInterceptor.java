package com.trio.pintree.login.interceptor;

import com.trio.pintree.login.util.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Optional;

@Component
@Slf4j
public class RequestInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String jwt = request.getHeader("Authorization");
        String uuid = JwtUtil.decodeJwt(jwt);

        return loginUser(request, uuid).isPresent();
    }

    private Optional<String> loginUser(HttpServletRequest request, String uuid){
        final HttpSession session = request.getSession();

        return Optional.ofNullable(session.getAttribute(uuid).toString());
    }
}
