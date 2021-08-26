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
        // given
        String uuid = "uuid";

        // when
        String jwt = JwtUtil.createJwt(uuid);

        // then
        String expectedJwt = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJqd3RJc3N1ZXIiLCJ1dWlkIjoidXVpZCJ9.EFC8iPNxtnqz0AUibGyM55m7MXjIOH-WUmkeZ_vmSWs";
        assertThat(jwt).isEqualTo(expectedJwt);
    }

    @ParameterizedTest
    @MethodSource("JWT_생성_실패")
    void JWT_생성_실패(String desc, String uuid, String expectedMessage) {
        assertThatThrownBy(() -> JwtUtil.createJwt(uuid)).as(desc).hasMessageContaining(expectedMessage);
    }

    static Stream<Arguments> JWT_생성_실패() {
        return Stream.of(
                Arguments.arguments(
                        "UUID가 빈 문자열인 경우",
                        "",
                        "JWT 생성 실패"
                ),
                Arguments.arguments(
                        "UUID가 null인 경우",
                        null,
                        "JWT 생성 실패"
                )
        );
    }

    @Test
    void 유효한_JWT의_페이로드_디코드_성공(){
        // given
        String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJqd3RJc3N1ZXIiLCJ1dWlkIjoidXVpZCJ9.EFC8iPNxtnqz0AUibGyM55m7MXjIOH-WUmkeZ_vmSWs";

        // when
        String uuid = JwtUtil.decodeJwt(token);

        // then
        String expectedUuid = "uuid";
        assertThat(uuid).isEqualTo(expectedUuid);
    }

    @ParameterizedTest
    @MethodSource("JWT_디코드_실패")
    void JWT_디코드_실패(String desc, String token, String expectedMessage) {
        assertThatThrownBy(() -> JwtUtil.decodeJwt(token)).as(desc).hasMessageContaining(expectedMessage);
    }

    static Stream<Arguments> JWT_디코드_실패() {
        return Stream.of(
                Arguments.arguments(
                        "Issuer가 잘못된 경우",
                        "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJ3cm9uZ0lzc3VlciIsInV1aWQiOiJ1dWlkIn0.LcliiAv4Of4BP1RtZ1CMevkxyi1CiJz1na97F00Uq-A",
                        "JWT 검증 실패"
                ),
                Arguments.arguments(
                        "JWT 형식이 잘못된 경우",
                        "wrongJWT",
                        "JWT 디코드 실패"
                )
        );
    }

}