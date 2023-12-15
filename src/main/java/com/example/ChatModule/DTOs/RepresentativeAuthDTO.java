package com.example.ChatModule.DTOs;

import com.example.ChatModule.entities.Representative;
import lombok.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@NonNull
public class RepresentativeAuthDTO {
    String login;
    String password;

    public RepresentativeAuthDTO(Representative rep) {
        this.login = rep.getLogin();
        this.password = rep.getPassword();
    }
}
