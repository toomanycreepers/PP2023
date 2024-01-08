package com.example.ChatModule.controllers;

import com.example.ChatModule.DTOs.EduProgramDTO;
import com.example.ChatModule.services.EduProgramService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private static final Logger logger = LoggerFactory.getLogger(EduProgramController.class);

    @PostMapping
    public ResponseEntity<HttpStatus> addProgram(@Valid @RequestBody EduProgramDTO dto){
        if(service.createEduProgram(dto)){
            logger.info("Добавлена образовательная программа {}.", dto.getId());
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
        logger.error("Ошибка добавления образовательной программы.");
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
        logger.info("Запрошена образовательная программа {}, отсутствующая в базе.", id);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteProgram(@PathVariable String id){
        if(service.deleteEduProgram(id)){
            logger.info("Удалена образовательная программа {}.", id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        logger.error("Ошибка удаления образовательной программы.");
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    @PutMapping
    public ResponseEntity<HttpStatus> updateProgram(@Valid @RequestBody EduProgramDTO dto){
        if(service.updateEduProgram(dto)){
            logger.info("Изменена образовательная программа {}.", dto.getId());
            return new ResponseEntity<>(HttpStatus.OK);
        }
        logger.error("Ошибка изменения образовательной программы.");
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}