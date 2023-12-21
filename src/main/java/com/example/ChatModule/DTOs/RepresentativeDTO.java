package com.example.ChatModule.DTOs;

import com.example.ChatModule.entities.EduProgram;
import com.example.ChatModule.entities.Representative;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@NonNull
public class RepresentativeDTO {
    private int id;
    private String firstname;
    private String lastname;
    private String patronimic;
    private int uniId;
    private List<EduProgramDTO> EPs;

    public RepresentativeDTO(Representative rep) {
        this.id = rep.getId();
        this.firstname = rep.getLastname();
        this.patronimic = rep.getPatronimic();
        this.uniId = rep.getUniversity().getId();

        var facultyEPs = rep.getEduPrograms();
        var dtos = new ArrayList<EduProgramDTO>();
        for (int i = 0; i < facultyEPs.toArray().length; i++) {
            EduProgram program = facultyEPs.get(i);
            dtos.add(new EduProgramDTO(program));

        }
        this.EPs = dtos;
    }
}
