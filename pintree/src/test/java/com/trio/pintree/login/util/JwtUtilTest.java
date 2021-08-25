package com.trio.pintree.login.util;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class JwtUtilTest {

    @Test
    void uuid를_페이로드로_JWT_생성에_성공한다() throws Exception {
        String uuid = "uuid";
        String jwt = JwtUtil.createJwt(uuid);
        String expectedJwt = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJqd3RJc3N1ZXIiLCJ1dWlkIjoidXVpZCJ9.EFC8iPNxtnqz0AUibGyM55m7MXjIOH-WUmkeZ_vmSWs";
        assertThat(jwt).isEqualTo(expectedJwt);
    }

    @ParameterizedTest
    @MethodSource("uuid가_비어있다면_JWT_생성은_실패한다")
    void uuid가_비어있다면_JWT_생성은_실패한다(String uuid, String expectedMessage) {
        assertThatThrownBy(() -> JwtUtil.createJwt(uuid)).hasMessageContaining(expectedMessage);
    }

    static Stream<Arguments> uuid가_비어있다면_JWT_생성은_실패한다() {
        return Stream.of(
                Arguments.arguments(
                        "",
                        "JWT 생성 실패"
                ),
                Arguments.arguments(
                        null,
                        "JWT 생성 실패"
                )
        );
    }
}