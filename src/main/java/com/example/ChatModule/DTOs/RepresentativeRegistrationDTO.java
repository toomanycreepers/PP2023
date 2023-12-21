package com.example.ChatModule.DTOs;

import com.example.ChatModule.entities.Representative;
import lombok.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@NonNull
public class RepresentativeRegistrationDTO {
    String firstname;
    String lastname;
    String patronimic;
    String uniName;
    String login;
    String password;
}
