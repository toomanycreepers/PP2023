package com.example.ChatModule.DTOs;

import com.example.ChatModule.entities.Graduate;
import jakarta.validation.constraints.*;
import lombok.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@NonNull
public class GraduateDTO {
    @NotNull
    @Min(1)
    long id;
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

    public GraduateDTO(Graduate grad){
        this.id=grad.getId();
        this.mail=grad.getMail();
        this.firstname=grad.getFirstname();
        this.lastname=grad.getLastname();
        this.patronimic = grad.getPatronimic();
        this.dateOfBirth = grad.getDateOfBirth().toString();
        this.gradFrom = grad.getGradFrom();
        this.region = grad.getRegion();
    }
}
