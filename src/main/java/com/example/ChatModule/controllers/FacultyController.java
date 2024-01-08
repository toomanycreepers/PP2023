package com.example.ChatModule.controllers;

import com.example.ChatModule.DTOs.EduProgramDTO;
import com.example.ChatModule.DTOs.FacultyCreationDTO;
import com.example.ChatModule.DTOs.FacultyDTO;
import com.example.ChatModule.services.FacultyService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/faculty")
public class FacultyController {
    @Autowired
    private FacultyService service;
    private static final Logger logger = LoggerFactory.getLogger(FacultyController.class);

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<FacultyDTO> getById(@PathVariable long id){
        FacultyDTO faculty = service.findById(id);
        if (faculty==null) {
            logger.debug("Запрошен факультет {}, отсутствующий в базе.", id);
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(faculty,HttpStatus.FOUND);
    }

    @PostMapping("/create")
    public ResponseEntity<HttpStatus> createFaculty(@Valid @RequestBody FacultyCreationDTO dto){
        if(service.createFaculty(dto)){
            logger.info("Добавлен {} университету {}.", dto.getName(),dto.getUniId());
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
        logger.error("Ошибка добавления {} университету {}.", dto.getName(),dto.getUniId());
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/{id}/programs")
    public ResponseEntity<HttpStatus> addEP(@PathVariable long id, @Valid @RequestBody EduProgramDTO dto){
        if(service.addEP(id,dto.getId())){
            logger.info("Добавлена образовательная программа {} факультету {}.",  dto.getId(), id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        logger.error("Ошибка добавления программы {} факультету {}.", dto.getId(), id);
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/{id}/programs/{programId}")
    public ResponseEntity<HttpStatus> removeEP(@PathVariable long id, @PathVariable String programId){
        if(service.removeEP(id,programId)){
            logger.info("Удалена образовательная программа {} у факультета {}.", programId, id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        logger.error("Ошибка удаления образовательной программы {} у факультета {}.", programId, id);
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> removeFaculty(@PathVariable long id){
        if(service.removeFaculty(id)){
            logger.info("Удален факультет {}.", id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        logger.info("Ошибка удаления факультета {}.", id);
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
