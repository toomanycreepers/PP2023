package com.example.ChatModule.security;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    ADMIN, GRADUATE, REPRESENTATIVE;
    public String getAuthority(){ return name(); }
}
