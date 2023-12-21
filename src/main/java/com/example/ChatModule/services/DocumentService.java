package com.example.ChatModule.services;

import com.example.ChatModule.DTOs.DocumentDTO;
import com.example.ChatModule.entities.Document;
import com.example.ChatModule.repositories.DocumentsRepository;
import com.example.ChatModule.repositories.GraduateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DocumentService {
    @Autowired
    private DocumentsRepository repo;
    @Autowired
    private GraduateRepository gradrepo;
    public void createDocument(DocumentDTO dto){
        Document doc = new Document();
        doc.setContent(dto.getContent());
        doc.setName(dto.getName());
        doc.setGraduate(gradrepo.findById(dto.getGraduateId()).get());
        repo.save(doc);
    }

    public void deleteDocument(long id){
        repo.deleteById(id);
    }

    public DocumentDTO getDocument(long id){
        var doc = repo.findById(id).orElse(null);
        if (doc!=null)
            return new DocumentDTO(doc);
        return null;
    }

    public List<DocumentDTO> getDocumentsByGraduate(long gradId){
        var docs = repo.findAllByGraduateId(gradId);
        var dtos = new ArrayList<DocumentDTO>();
        for (int i=0;i<docs.toArray().length;i++){
            Document program = docs.get(i);
            dtos.add(new DocumentDTO(program));
        }
        return dtos;
    }
}
