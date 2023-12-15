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
    /**
     * TODO: Представители не знают id своего вуза. Сделать выбор по имени?
     */
    int uniId;
    String login;
    String password;
}
