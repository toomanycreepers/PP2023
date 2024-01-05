package com.example.ChatModule.controllers;

import com.example.ChatModule.DTOs.DocumentDTO;
import com.example.ChatModule.services.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/doc")
public class DocumentController {
    @Autowired
    DocumentService service;
    @GetMapping(value = "/{docId}",produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<byte[]> getFileById(@PathVariable long docId){
        DocumentDTO doc = service.getDocument(docId);

        if (doc==null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDisposition(ContentDisposition.builder("attachment").filename(doc.getName()).build());
        return ResponseEntity.ok().headers(headers).body(doc.getContent());
    }
    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<HttpStatus> addFile(@RequestPart("content")MultipartFile file,
                        @RequestParam("name") String name,
                        @RequestParam("graduateId") long graduateId){
        try {
            byte[] content = file.getBytes();
            DocumentDTO dto = new DocumentDTO(content,name,graduateId);
            service.createDocument(dto);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
        catch (IOException e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{docId}")
    public ResponseEntity<HttpStatus> removeFile(@PathVariable long docId){
        if(service.deleteDocument(docId)){
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }


}
