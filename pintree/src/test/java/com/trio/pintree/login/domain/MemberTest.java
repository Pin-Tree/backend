package com.trio.pintree.login.domain;


import com.trio.pintree.login.service.MemberService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

import static org.assertj.core.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Transactional
class MemberTest {

    @Autowired
    MemberService memberService;

    @Test
    @DisplayName("회원 정보 추가 여부를 확인한다.")
    void memberInsertTest() {
        //given
        Member member = new Member("유저네임1", "닉네임1");

        //when
        UUID memberId = memberService.joinMember(member);

        //then
        assertThat(member.getId())
                .isEqualTo(memberService.findById(memberId).getUuid());
    }
}
