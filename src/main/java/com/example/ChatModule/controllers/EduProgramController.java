package com.example.ChatModule.controllers;

import com.example.ChatModule.DTOs.EduProgramDTO;
import com.example.ChatModule.services.impl.EduProgramServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/EP")
public class EduProgramController {
    @Autowired
    private EduProgramServiceImpl service;
    @PostMapping
    public ResponseEntity<HttpStatus> AddProgram(@RequestBody EduProgramDTO dto){
        if(dto != null){
            service.createEduProgram(dto);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping
    @ResponseBody
    public ResponseEntity<List<EduProgramDTO>> GetAllPrograms(){
        return new ResponseEntity<>(service.getAllEduPrograms(),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<EduProgramDTO> GetProgramById(@PathVariable String id){
        EduProgramDTO program = service.getEduProgram(id);
        if(program != null) return new ResponseEntity<>(program, HttpStatus.FOUND);
            else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}