package com.trio.pintree.login.domain;

import com.trio.pintree.login.dto.oauth.UserProfile;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;


@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class Member {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(16)", name = "member_id")
    private UUID id;
    private String email;
    private String nickname;
    private String profileUrl;

    private Member(String email, String nickname, String profileUrl) {
        this.email = email;
        this.nickname = nickname;
        this.profileUrl = profileUrl;
    }

    public static Member create(String email, String nickname, String profileUrl) {
        return new Member(email, nickname, profileUrl);
    }
}
