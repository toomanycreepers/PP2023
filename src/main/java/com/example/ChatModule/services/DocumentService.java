package com.example.ChatModule.services;

import com.example.ChatModule.DTOs.DocumentDTO;
import com.example.ChatModule.entities.Document;
import com.example.ChatModule.repositories.DocumentsRepository;
import com.example.ChatModule.repositories.GraduateRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class DocumentService {
    @Autowired
    private DocumentsRepository repo;
    @Autowired
    private GraduateRepository gradrepo;
    @PreAuthorize("hasRole('GRAD')")
    public void createDocument(@Valid DocumentDTO dto){
        Document doc = new Document();
        doc.setContent(dto.getContent());
        doc.setName(dto.getName());
        doc.setGraduate(gradrepo.findById(dto.getGraduateId()).orElse(null));
        repo.save(doc);
    }

    @PreAuthorize("hasRole('GRAD', 'ADMIN')")
    public boolean deleteDocument(long id){
        boolean exists = repo.existsById(id);
        repo.deleteById(id);
        return exists;
    }
    @PreAuthorize("hasRole('GRAD')")
    public DocumentDTO getDocument(long id){
        var doc = repo.findById(id).orElse(null);
        if (doc!=null)
            return new DocumentDTO(doc);
        return null;
    }
    @PreAuthorize("hasRole('GRAD')")
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
