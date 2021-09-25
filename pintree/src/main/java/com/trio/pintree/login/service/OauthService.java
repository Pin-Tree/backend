package com.trio.pintree.login.service;

import com.trio.pintree.login.domain.Member;
import com.trio.pintree.login.dto.AuthRequest;
import com.trio.pintree.login.dto.oauth.AccessTokenResponse;
import com.trio.pintree.login.dto.oauth.UserProfile;
import com.trio.pintree.login.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public abstract class OauthService {

    private final MemberRepository memberRepository;
    private final SessionService sessionService;

    abstract UserProfile getMemberFrom(AccessTokenResponse accessTokenResponse);

    abstract AccessTokenResponse issueAccessToken(AuthRequest authRequest);

    public Member login(UserProfile userProfile) {
        Optional<Member> member = memberRepository.findByEmail(userProfile.getEmail());

        if (member.isPresent()) {
            return member.get();
        }

        // 회원가입
        Member newMember = Member.create(userProfile.getEmail(), userProfile.getNickname(), "defaultProfile");

        Member savedMember = memberRepository.save(newMember);
        sessionService.login(savedMember.getId().toString(), savedMember);

        return savedMember;
    }
}
