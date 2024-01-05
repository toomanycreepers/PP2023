package com.example.ChatModule.DTOs;

import com.example.ChatModule.entities.Graduate;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@NonNull
public class GraduateRegistrationDTO {
    @NotBlank
    @Email
    String mail;
    @NotBlank
    String firstname;
    @NotBlank
    String lastname;
    String patronimic;
    @NotBlank
    @Pattern(regexp = "^[0-9]{4}-[0-9]{2}-[0-9]{2}$")
    String dateOfBirth;
    @NotBlank
    String gradFrom;
    @NotBlank
    String region;
    @NotBlank
    @Size(min = 8,max = 32)
    String password;
}
