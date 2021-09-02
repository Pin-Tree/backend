package com.trio.pintree.login.service;

import com.trio.pintree.login.domain.Member;
import com.trio.pintree.login.dto.AuthRequest;
import com.trio.pintree.login.dto.oauth.AccessTokenResponse;
import com.trio.pintree.login.dto.oauth.UserProfile;
import com.trio.pintree.login.repository.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public abstract class OauthService {

    private final MemberRepository memberRepository;

    public OauthService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    abstract UserProfile getMemberFrom(AccessTokenResponse accessTokenResponse);

    abstract AccessTokenResponse issueAccessToken(AuthRequest authRequest);

    public Member findMember(UserProfile userProfile) {
        Optional<Member> member = memberRepository.findByEmail(userProfile.getEmail());

        if (member.isPresent()) {
            return member.get();
        }

        Member newMember = Member.create(userProfile.getEmail(), userProfile.getNickname(), null);
        return memberRepository.save(newMember);
    }
}
