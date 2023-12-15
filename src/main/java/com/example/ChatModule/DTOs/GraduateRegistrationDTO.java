package com.example.ChatModule.DTOs;

import com.example.ChatModule.entities.Graduate;
import lombok.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@NonNull
public class GraduateRegistrationDTO {
    String mail;
    String firstname;
    String lastname;
    String patronimic;
    String dateOfBirth;
    String gradFrom;
    String region;
    String password;
}
