package com.example.ChatModule.DTOs;

import com.example.ChatModule.entities.University;
import lombok.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@NonNull
public class UniversityDTO {
    int id;
    String name;

    public UniversityDTO(University uni){
        this.id=uni.getId();
        this.name= uni.getName();
    }
}
