package com.trio.pintree.login.dto.oauth;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
public class KaKaoUserProfile implements UserProfile{

    private Long id;
    private String connectedAt;
    private KaKaoProperties properties;
    private KaKaoAccount kakaoAccount;

    @JsonGetter("id")
    public Long getId() {
        return id;
    }

    @JsonSetter("id")
    public void setId(Long id) {
        this.id = id;
    }

    @JsonGetter("connected_at")
    public String getConnectedAt() {
        return connectedAt;
    }

    @JsonSetter("connected_at")
    public void setConnectedAt(String connectedAt) {
        this.connectedAt = connectedAt;
    }

    @JsonGetter("properties")
    public KaKaoProperties getProperties() {
        return properties;
    }

    @JsonSetter("properties")
    public void setProperties(KaKaoProperties properties) {
        this.properties = properties;
    }

    @JsonGetter("kakao_account")
    public KaKaoAccount getKakaoAccount() {
        return kakaoAccount;
    }

    @JsonSetter("kakao_account")
    public void setKakaoAccount(KaKaoAccount kakaoAccount) {
        this.kakaoAccount = kakaoAccount;
    }

    @Override
    public String getEmail() {
        return kakaoAccount.getEmail();
    }

    @Override
    public String getNickname() {
        return properties.getNickName();
    }
}
