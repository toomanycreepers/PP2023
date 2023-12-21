package com.example.ChatModule.DTOs;

import com.example.ChatModule.entities.EduProgram;
import com.example.ChatModule.entities.Faculty;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@NonNull
public class FacultyDTO {
    long id;
    String name;
    int uniId;
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
