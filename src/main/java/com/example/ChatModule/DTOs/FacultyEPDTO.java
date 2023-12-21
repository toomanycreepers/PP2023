package com.example.ChatModule.DTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class FacultyEPDTO {
    String name;
    List<EduProgramDTO> educationPrograms;
}
