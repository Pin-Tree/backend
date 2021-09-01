package com.trio.pintree.login.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@Getter
@RedisHash("auth")
@ToString
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public class Auth {

    @Id
    private final String UUID;

    private final Member member;

    public static Auth from(String uuid, Member member) {
        return new Auth(uuid, member);
    }

    public String getEmail() {
        return member.getEmail();
    }

    public String getNickname() {
        return member.getNickname();
    }

    public String getProfile() {
        return member.getProfileUrl();
    }
}
