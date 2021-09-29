package com.trio.pintree.login.resolver;

import com.trio.pintree.login.exception.NotMatchedUserException;
import com.trio.pintree.login.repository.AuthRepository;
import com.trio.pintree.login.util.JwtUtil;
import com.trio.pintree.login.util.JwtValidator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

@Slf4j
@Component
@RequiredArgsConstructor
public class LoginMemberArgumentResolver implements HandlerMethodArgumentResolver {
    private final AuthRepository authRepository;

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        log.debug("LoginMemberArgumentResolver 실행");
        boolean hasLoginAnnotation = parameter.hasParameterAnnotation(Login.class);
        boolean isUUIDType = UUID.class.isAssignableFrom(parameter.getParameterType());
        return hasLoginAnnotation && isUUIDType;
    }

    @Override
    public Object resolveArgument(MethodParameter parameter,
                                  ModelAndViewContainer mavContainer,
                                  NativeWebRequest webRequest,
                                  WebDataBinderFactory binderFactory) {

        log.debug("LoginMemberArgumentResolver.resolveArgument");

        HttpServletRequest request = (HttpServletRequest) webRequest.getNativeRequest();
        String headerAsString = request.getHeader(HttpHeaders.AUTHORIZATION);
        JwtValidator.validateJwtHeader(headerAsString);

        String uuid = extractMemberIdFromEncodedJwt(headerAsString);
        log.debug("uuid : {}", uuid);

        if (!authRepository.existsById(uuid)) {
            throw new NotMatchedUserException();
        }
        return UUID.fromString(uuid);
    }

    private String extractMemberIdFromEncodedJwt(String headerAsString) {
        String[] split = headerAsString.split(" ");
        String jwt = split[1];
        return JwtUtil.decodeJwt(jwt);
    }
}
