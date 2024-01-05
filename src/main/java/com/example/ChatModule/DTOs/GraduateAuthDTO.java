package com.example.ChatModule.DTOs;

import com.example.ChatModule.entities.Graduate;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@NonNull
public class GraduateAuthDTO {
    @NotBlank
    @Email
    String mail;
    @NotBlank
    String password;

    public GraduateAuthDTO(Graduate grad){
        this.mail=grad.getMail();
        this.password = grad.getPassword();
    }
}
