package com.example.ChatModule.DTOs;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class FacultyEPDTO {
    @NotBlank
    String name;
    @NotNull
    List<EduProgramDTO> educationPrograms;
}
