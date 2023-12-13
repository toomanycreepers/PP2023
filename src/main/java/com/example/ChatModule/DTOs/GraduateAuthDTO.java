package com.example.ChatModule.DTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.Value;

@Value
@AllArgsConstructor
@NonNull
public class GraduateAuthDTO {
    String mail;
    String password;
}
