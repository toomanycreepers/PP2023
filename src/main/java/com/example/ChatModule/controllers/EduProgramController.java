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
    @ResponseBody
    public ResponseEntity<HttpStatus> EduProgram(@RequestBody EduProgramDTO dto){
        if(dto != null){
            service.createEduProgram(dto);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping
    @ResponseBody
    public ResponseEntity<List<EduProgramDTO>> EduProgram(){
        return new ResponseEntity<>(service.getAllEduPrograms(),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<HttpStatus> EduProgram(@PathVariable String id){
        if(service.getEduProgram(id) != null) return new ResponseEntity<>(HttpStatus.FOUND);
            else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}