package com.example.ChatModule.DTOs;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UniversityCreationDTO {
    @NotBlank
    private String name;
}
