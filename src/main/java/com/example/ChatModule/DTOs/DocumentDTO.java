package com.example.ChatModule.DTOs;

import com.example.ChatModule.entities.Document;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class DocumentDTO {
    Long id;
    byte[] content;
    private Long graduateId;

    public DocumentDTO(Document doc){
        this.id = doc.getId();
        this.content = doc.getContent();
        this.graduateId = doc.getGraduate().getId();
    }
}
