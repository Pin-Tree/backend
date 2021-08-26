package com.trio.pintree.login.service;

import com.trio.pintree.login.domain.Member;
import com.trio.pintree.login.dto.MemberResponseDto;
import com.trio.pintree.login.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public UUID joinMember(Member member) {
        memberRepository.save(member);
        return member.getId();
    }

    public MemberResponseDto findById(UUID memberId) {
        Member member = memberRepository.findById(memberId);
        return MemberResponseDto.fromEntity(member);
    }

}
