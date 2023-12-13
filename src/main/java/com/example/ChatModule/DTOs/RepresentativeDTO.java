package com.example.ChatModule.DTOs;

import lombok.*;

@Value
@AllArgsConstructor
@NonNull
public class RepresentativeDTO {
    int id;
    String firstname;
    String lastname;
    String patronimic;
    int university;
}
