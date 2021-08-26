package com.trio.pintree.login.dto;

import com.trio.pintree.login.domain.Member;
import lombok.*;

import java.util.UUID;

@RequiredArgsConstructor (access = AccessLevel.PRIVATE)
@Builder
@Getter
@ToString
public class MemberResponseDto {

    private final UUID uuid;
    private final String username;
    private final String nickname;

    public static MemberResponseDto fromEntity(Member member) {
        return MemberResponseDto.builder()
                .uuid(member.getId())
                .username(member.getEmail())
                .nickname(member.getNickname())
                .build();
    }

}
