package com.example.ChatModule.DTOs;

import lombok.*;

import java.util.List;

@Value
@AllArgsConstructor
@NonNull
public class FacultyDTO {
    long id;
    int university;
    List<EduProgramDTO> EPs;
}
