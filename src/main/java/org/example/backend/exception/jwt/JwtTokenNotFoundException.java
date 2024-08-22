package org.example.backend.exception.jwt;

import io.jsonwebtoken.JwtException;

public class JwtTokenNotFoundException extends JwtException {
    public JwtTokenNotFoundException(){
        super("JWT Not Found");
    }
}
