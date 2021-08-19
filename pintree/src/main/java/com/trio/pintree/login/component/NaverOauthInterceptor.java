package com.trio.pintree.login.component;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

@Component
@Slf4j
public class NaverOauthInterceptor implements HandlerInterceptor {

    private static final String SECURE_RANDOM_ALORIGHM = "SHA1PRNG";
    private static final String STATE = "state";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws NoSuchAlgorithmException {
        final HttpSession session = request.getSession();
        session.setAttribute(STATE, generateState());
        return true;
    }

    public String generateState() throws NoSuchAlgorithmException {
        SecureRandom random = SecureRandom.getInstance(SECURE_RANDOM_ALORIGHM);
        return new BigInteger(130, random).toString(32);
    }

}

