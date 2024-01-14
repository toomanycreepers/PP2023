package com.example.ChatModule.DTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AdminDTO {
    private int id;
    private String name;
    private String password;
}
