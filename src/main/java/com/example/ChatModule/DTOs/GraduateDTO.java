package com.example.ChatModule.DTOs;

import lombok.*;

@Value
@AllArgsConstructor
@NonNull
public class GraduateDTO {
    long id;
    String mail;
    String firstname;
    String lastname;
    String patronimic;
    String dateOfBirthday;
    String gradFrom;
    String region;
}
