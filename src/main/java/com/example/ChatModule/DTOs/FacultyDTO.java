package com.example.ChatModule.DTOs;

import com.example.ChatModule.entities.EduProgram;
import com.example.ChatModule.entities.Faculty;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@NonNull
public class FacultyDTO {
    @NotNull
    @Min(1)
    long id;
    @NotBlank
    String name;
    @NotNull
    @Min(1)
    int uniId;
    @NotNull
    List<EduProgramDTO> EPs;

    public FacultyDTO(Faculty faculty){
        this.id=faculty.getId();
        this.uniId=faculty.getUniversity().getId();
        var facultyEPs = faculty.getEduPrograms();
        var dtos = new ArrayList<EduProgramDTO>();
        for (int i=0;i<facultyEPs.toArray().length;i++){
            EduProgram program = facultyEPs.get(i);
            dtos.add(new EduProgramDTO(program));
        }
        this.EPs = dtos;
    }
}
