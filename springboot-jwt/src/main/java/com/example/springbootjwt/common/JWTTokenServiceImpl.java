package com.example.springbootjwt.common;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.springbootjwt.entity.User;
import org.springframework.stereotype.Service;

@Service
public class JWTTokenServiceImpl implements TokenService{
    private static final String KEY = "SECRET";

    private static final String ISSUER = "AUTH0";

    private Algorithm algorithm = Algorithm.HMAC256(KEY);

    @Override
    public String generateToken(User user) {

        String jwt = JWT.create()
                .withIssuer(ISSUER)
                .withClaim("sub", "JWT-Demo")
                .withClaim("name", user.getName())
                .withClaim("admin", true)
                .sign(algorithm);
        return jwt;
    }

    @Override
    public boolean verifyToken(String token) {
        boolean flags = false;
        try {
            JWTVerifier verifier = JWT.require(algorithm)
                    .withIssuer(ISSUER)
                    .build();
            DecodedJWT decodedJWT = verifier.verify(token);
            flags = true;
        }catch (JWTVerificationException e){
            e.printStackTrace();
        }
        return flags;
    }
}
