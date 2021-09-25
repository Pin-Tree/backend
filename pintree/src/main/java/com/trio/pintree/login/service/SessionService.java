package com.trio.pintree.login.service;

import com.trio.pintree.login.domain.Auth;
import com.trio.pintree.login.domain.Member;
import com.trio.pintree.login.exception.AuthenticationException;
import com.trio.pintree.login.repository.AuthRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SessionService {
    private final AuthRepository authRepository;

    public void login(String uuid, Member member) {
        Auth auth = Auth.from(uuid, member);
        authRepository.save(auth);
    }

    public void logout(String uuid) {
        if (uuid != null) {
            authRepository.deleteById(uuid);
        }
    }

    public Member getMember(String uuid) {
        Auth auth = authRepository.findById(uuid).orElseThrow(() -> new AuthenticationException("로그인하지 않은 유저입니다."));
        return auth.getMember();
    }
}
