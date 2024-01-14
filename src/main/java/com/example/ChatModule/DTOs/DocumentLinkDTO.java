package com.example.ChatModule.DTOs;

import com.example.ChatModule.entities.Document;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class DocumentLinkDTO {
    private String name;
    private String link;

    public DocumentLinkDTO(Document doc){
        this.name = doc.getName();
        this.link = "/doc/" + doc.getId().toString();
    }
}
