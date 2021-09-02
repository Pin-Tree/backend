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
    private final String email;
    private final String nickname;
    private final String profile;

    public static MemberResponseDto fromEntity(Member member) {
        return MemberResponseDto.builder()
                .uuid(member.getId())
                .email(member.getEmail())
                .nickname(member.getNickname())
                .profile(member.getProfileUrl())
                .build();
    }

}
