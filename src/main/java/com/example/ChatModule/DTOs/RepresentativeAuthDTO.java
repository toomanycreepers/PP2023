package com.example.ChatModule.DTOs;

import com.example.ChatModule.entities.Representative;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@NonNull
public class RepresentativeAuthDTO {
    @NotBlank
    String login;
    @NotBlank
    String password;

    public RepresentativeAuthDTO(Representative rep) {
        this.login = rep.getLogin();
        this.password = rep.getPassword();
    }
}
