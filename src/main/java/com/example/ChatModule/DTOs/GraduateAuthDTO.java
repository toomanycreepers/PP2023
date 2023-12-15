package com.example.ChatModule.DTOs;

import com.example.ChatModule.entities.Graduate;
import lombok.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@NonNull
public class GraduateAuthDTO {
    String mail;
    String password;

    public GraduateAuthDTO(Graduate grad){
        this.mail=grad.getMail();
        this.password = grad.getPassword();
    }
}
