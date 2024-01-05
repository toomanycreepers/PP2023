package com.example.ChatModule.security;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {// очень вероятно придется делать таблицей в бд(надеюсь что нет но как будто да)
    ADMIN, GRADUATE, REPRESENTATIVE;
    public String getAuthority(){ return name(); }
}
