package com.example.ChatModule.DTOs;

import com.example.ChatModule.entities.EduProgram;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.*;


@Getter
@AllArgsConstructor
@NoArgsConstructor
public class EduProgramDTO {
    @NotBlank
    @Pattern(regexp = "\\d{2}\\.\\d{2}\\.\\d{2}",message = "Неверный формат ID.")
    String id;
    @NotBlank
    String name;

    public EduProgramDTO(EduProgram EP){
        this.id=EP.getId();
        this.name = EP.getName();
    }
}
