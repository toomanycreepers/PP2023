package com.example.ChatModule.DTOs;

import lombok.*;

@Value
@AllArgsConstructor
@NonNull
public class RepresentativeRegistrationDTO {
    int id;
    String firstname;
    String lastname;
    String patronimic;
    int university;
    String login;
    String password;
}
