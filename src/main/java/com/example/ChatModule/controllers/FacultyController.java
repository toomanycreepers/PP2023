package com.example.ChatModule.controllers;
//TODO
import com.example.ChatModule.DTOs.EduProgramDTO;
import com.example.ChatModule.DTOs.FacultyCreationDTO;
import com.example.ChatModule.DTOs.FacultyDTO;
import com.example.ChatModule.services.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/faculty")
public class FacultyController {
    @Autowired
    FacultyService service;

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<FacultyDTO> getById(@PathVariable long id){
        FacultyDTO faculty = service.findById(id);
        if (faculty==null) return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(faculty,HttpStatus.FOUND);
    }

    @PostMapping("/create")
    public ResponseEntity<HttpStatus> createFaculty(@RequestBody FacultyCreationDTO dto){
        if (dto==null) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        service.createFaculty(dto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/{id}/programs")
    public ResponseEntity<HttpStatus> addEP(@PathVariable long id, @RequestBody EduProgramDTO dto){
        service.addEP(id,dto.getId());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}/programs/{programId}")
    public ResponseEntity<HttpStatus> removeEP(@PathVariable long id, @PathVariable String programId){
        service.removeEP(id,programId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> removeFaculty(@PathVariable long id){
        service.removeFaculty(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
