package com.example.ChatModule.DTOs;

import lombok.*;

@Value
@AllArgsConstructor
@NonNull
public class RepresentativeAuthDTO {
    String login;
    String password;
}
