package com.example.ChatModule.DTOs;

import com.example.ChatModule.entities.University;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@NonNull
public class UniversityDTO {
    @NotNull
    @Min(1)
    int id;
    @NotBlank
    String name;

    public UniversityDTO(University uni){
        this.id=uni.getId();
        this.name= uni.getName();
    }
}
