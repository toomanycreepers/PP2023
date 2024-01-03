package com.example.ChatModule.DTOs;

import com.example.ChatModule.entities.Representative;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@NonNull
public class RepresentativeRegistrationDTO {
    @NotBlank
    String firstname;
    @NotBlank
    String lastname;
    String patronimic;
    @NotBlank
    String uniName;
    @NotBlank
    String login;
    @NotBlank
    @Size(min = 8,max = 32)
    String password;
}
