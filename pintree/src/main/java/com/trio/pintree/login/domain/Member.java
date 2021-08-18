package com.trio.pintree.login.domain;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class Member {
    private Long id;
    private String username;
    private String nickname;

    public Member(Long id, String username) {
        this.id = id;
        this.username = username;
    }
}
