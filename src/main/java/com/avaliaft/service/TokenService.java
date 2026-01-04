package com.avaliaft.service;


import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.avaliaft.models.Usuario;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class TokenService {
    @Value("${api.security.token.secret}")
    String secret;
    @Value("${api.security.token.issuer}")
    String issuer;

    public String gerarToken (Usuario usuario){
       Algorithm algorithm = Algorithm.HMAC256(secret);


       return JWT.create()
               .withIssuer(issuer)
               .withSubject(usuario.getLogin())
               .withExpiresAt(Instant.now().plusSeconds(7200))
               .sign(algorithm);
    }


    public String validarToken(String tokeJWT){

        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);

            return JWT.require(algorithm)
                    .withIssuer(issuer)
                    .build()
                    .verify(tokeJWT)
                    .getSubject();
        }catch (JWTVerificationException e){
            return null;

        }


    }

}
