package com.nuketree3.example.springhw2.enums;

import org.springframework.security.core.GrantedAuthority;

public enum Roles implements GrantedAuthority {
    ROLE_USER,
    ROLE_READER,
    ROLE_ADMIN;

    @Override
    public String getAuthority() {
        return name();
    }

}
