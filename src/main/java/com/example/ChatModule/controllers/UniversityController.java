package com.example.ChatModule.controllers;

import com.example.ChatModule.DTOs.FacultyEPDTO;
import com.example.ChatModule.DTOs.UniversityCreationDTO;
import com.example.ChatModule.services.UniversityService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/university")
public class UniversityController {
    @Autowired
    UniversityService service;

    @GetMapping("/{uniId}/programs")
    public ResponseEntity<List<FacultyEPDTO>> getUniversityPrograms(@PathVariable int uniId){
        return new ResponseEntity<>(service.getUniversityEPs(uniId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<HttpStatus> addUniversity(@Valid @RequestBody UniversityCreationDTO dto){
        if(service.addUniversity(dto)){
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/{uniId}")
    public ResponseEntity<HttpStatus> removeUniversity(@PathVariable int uniId){
        if(service.removeUniversity(uniId)) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
