package com.trio.pintree.login.repository;

import com.trio.pintree.login.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class JpaMemberRepository implements MemberRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(Member member) {
        entityManager.persist(member);
    }

    @Override
    public Member findById(UUID memberId) {
        return entityManager.find(Member.class, memberId);
    }
}
