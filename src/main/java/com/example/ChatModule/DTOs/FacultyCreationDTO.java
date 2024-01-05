package com.example.ChatModule.DTOs;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class FacultyCreationDTO {
    @NotBlank
    String name;
    @NotNull
    @Min(1)
    int uniId;
}
