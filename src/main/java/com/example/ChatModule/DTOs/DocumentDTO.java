package com.example.ChatModule.DTOs;

import com.example.ChatModule.entities.Document;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class DocumentDTO {
    @NotNull
    private byte[] content;
    @NotBlank
    @NotNull
    private String name;
    @NotNull
    @Min(1)
    private Long graduateId;

    public DocumentDTO(Document doc){
        this.content = doc.getContent();
        this.name= doc.getName();
        this.graduateId = doc.getGraduate().getId();
    }
}
