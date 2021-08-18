package com.trio.pintree.login.repository;

import com.trio.pintree.login.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


@Repository
public class MemoryMemberRepository implements MemberRepository {
    private static Map<Long, Member> memoryDb = new ConcurrentHashMap<>();
    private static long sequence = 0L;

    @Override
    public Long save(Member member) {
        member.setId(++sequence);
        memoryDb.put(member.getId(), member);
        return member.getId();
    }
}
