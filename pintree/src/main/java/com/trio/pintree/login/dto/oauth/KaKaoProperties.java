package com.trio.pintree.login.dto.oauth;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@NoArgsConstructor
public class KaKaoProperties {

    private String nickName;

    @JsonGetter("nickname")
    public String getNickName() {
        return nickName;
    }

    @JsonSetter("nickname")
    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

}
