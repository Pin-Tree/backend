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

    public static String createJwt(String uuid) throws Exception {
        try {
            if (uuid == null || uuid.length() == 0) {
                throw new Exception("JWT 생성 실패");
            }

            Algorithm algorithm = Algorithm.HMAC256(JWT_SECRET);
            return JWT.create()
                    .withIssuer(JWT_ISSUER)
                    .withClaim(UUID, uuid)
                    .sign(algorithm);
        } catch (JWTCreationException exception) {
            throw new JwtException("JWT 생성 실패");
        }
    }

    public static String decodeJwt(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(JWT_SECRET);
            JWTVerifier verifier = JWT.require(algorithm)
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
