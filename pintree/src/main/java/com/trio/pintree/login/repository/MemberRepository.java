package com.trio.pintree.login.repository;

import com.trio.pintree.login.domain.Member;

import java.util.UUID;

public interface MemberRepository {
    void save(Member member);

    Member findById(UUID memberId);
}
