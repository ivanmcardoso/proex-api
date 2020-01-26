package com.gear.proex.security;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter @Setter
public class AccountCredentialsVO implements Serializable {

    private String username;
    private String password;
}
