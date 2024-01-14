package com.example.ChatModule.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.security.core.GrantedAuthority;

@AllArgsConstructor
@NoArgsConstructor
public class Role implements GrantedAuthority {
    private String name;
    @Override
    public String getAuthority(){ return this.name; }
    @Override
    public String toString(){
        return name;
    }
}
