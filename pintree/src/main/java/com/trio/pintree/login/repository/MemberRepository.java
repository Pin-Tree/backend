package com.trio.pintree.login.repository;

import com.trio.pintree.login.domain.Member;

public interface MemberRepository {
    Long save(Member member);
}
