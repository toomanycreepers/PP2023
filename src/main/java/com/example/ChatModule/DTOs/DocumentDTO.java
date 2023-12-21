package com.example.ChatModule.DTOs;

import com.example.ChatModule.entities.Document;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class DocumentDTO {
    private byte[] content;
    private String name;
    private Long graduateId;

    public DocumentDTO(Document doc){
        this.content = doc.getContent();
        this.name= doc.getName();
        this.graduateId = doc.getGraduate().getId();
    }
}
