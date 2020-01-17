package com.gear.proex.exeption;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidAuthenticationExeption extends AuthenticationException {

    public InvalidAuthenticationExeption(String msg) {
        super(msg);
    }
}
