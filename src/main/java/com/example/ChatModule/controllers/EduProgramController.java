package com.example.ChatModule.controllers;

import com.example.ChatModule.DTOs.EduProgramDTO;
import com.example.ChatModule.services.EduProgramService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/EP")
public class EduProgramController {
    @Autowired
    private EduProgramService service;
    @PostMapping
    public ResponseEntity<HttpStatus> addProgram(@RequestBody EduProgramDTO dto){
        if(service.createEduProgram(dto)){
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping
    @ResponseBody
    public ResponseEntity<List<EduProgramDTO>> getAllPrograms(){
        return new ResponseEntity<>(service.getAllEduPrograms(),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<EduProgramDTO> getProgramById(@PathVariable String id){
        EduProgramDTO program = service.getEduProgram(id);
        if(program != null) {
            return new ResponseEntity<>(program, HttpStatus.FOUND);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteProgram(@PathVariable String id){
        if(service.deleteEduProgram(id)){
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    @PutMapping
    public ResponseEntity<HttpStatus> updateProgram(@RequestBody EduProgramDTO dto){
        if(service.updateEduProgram(dto)){
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}