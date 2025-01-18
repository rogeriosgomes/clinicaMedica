package com.clinicaMedica.clinicaMedica.infra.Security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.clinicaMedica.clinicaMedica.model.usuario.Usuario;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    @Value("${api.security.token.secret}")
    private String secret;


    public String gerarToken(Usuario usuario) {

        try {
            var algoritmo = Algorithm.HMAC256(secret);
            return JWT.create()
                    .withIssuer("auth0")
                    .withSubject(usuario.getLogin())
                    .withExpiresAt(dataExpiracao())
                    .sign(algoritmo);
        } catch (JWTCreationException exception){
            throw new RuntimeException("Erro ao gerar token jwt", exception);
        }
    }

    public String getSubject(String token) {
        try {

            Algorithm algorithm = Algorithm.HMAC256(secret);
            return JWT.require(algorithm)
                    // specify any specific claim validations
                    .withIssuer("auth0")
                    // reusable verifier instance
                    .build()
                    .verify(token)
                    .getSubject();


        } catch (JWTVerificationException exception) {
            throw new RuntimeException("Erro ao verificar token", exception);
        }
    }

    private Instant dataExpiracao() {
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }
}
