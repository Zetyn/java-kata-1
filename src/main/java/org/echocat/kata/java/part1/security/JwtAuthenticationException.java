package org.echocat.kata.java.part1.security;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;

@Getter
public class JwtAuthenticationException extends AuthenticationException {
    private HttpStatus httpStatus;

    public JwtAuthenticationException(String msg, HttpStatus httpStatus) {
        super(msg);
        this.httpStatus = httpStatus;
    }

    public JwtAuthenticationException(String msg) {
        super(msg);
    }
}
