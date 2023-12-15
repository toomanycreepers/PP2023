package com.example.ChatModule.DTOs;

import com.example.ChatModule.entities.EduProgram;
import lombok.*;


@Getter
@AllArgsConstructor
@NoArgsConstructor
public class EduProgramDTO {
    String id;
    String name;

    public EduProgramDTO(EduProgram EP){
        this.id=EP.getId();
        this.name = EP.getName();
    }
}
