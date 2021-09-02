package com.trio.pintree.login.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;
import com.trio.pintree.login.exception.JwtException;

public class JwtUtil {

    private static final String JWT_SECRET = "jwtSecret";
    private static final String JWT_ISSUER = "jwtIssuer";
    private static final String UUID = "uuid";

    public static String createJwt(String uuid) {
        try {
            validateUUID(uuid);

            return JWT.create()
                    .withIssuer(JWT_ISSUER)
                    .withClaim(UUID, uuid)
                    .sign(Algorithm.HMAC256(JWT_SECRET));
        } catch (JWTCreationException exception) {
            throw new JwtException("JWT 생성 실패");
        }
    }

    private static void validateUUID(String uuid) {
        if (uuid == null || uuid.length() == 0) {
            throw new JwtException("유효한 UUID가 아닙니다");
        }
    }

    public static String decodeJwt(String token) {
        try {
            JWTVerifier verifier = JWT.require(Algorithm.HMAC256(JWT_SECRET))
                    .withIssuer(JWT_ISSUER)
                    .build();
            DecodedJWT jwt = verifier.verify(token);
            return jwt.getClaim(UUID).asString();
        } catch (JWTDecodeException exception) {
            throw new JwtException("JWT 디코드 실패");
        } catch (JWTVerificationException exception) {
            throw new JwtException("JWT 검증 실패");
        }
    }
}
