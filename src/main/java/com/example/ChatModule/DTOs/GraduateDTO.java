package com.example.ChatModule.DTOs;

import com.example.ChatModule.entities.Graduate;
import lombok.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@NonNull
public class GraduateDTO {
    long id;
    String mail;
    String firstname;
    String lastname;
    String patronimic;
    String dateOfBirth;
    String gradFrom;
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
