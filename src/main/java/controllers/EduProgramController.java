package controllers;

import DTOs.EduProgramDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import services.EduProgramService;

@Controller
@RequestMapping(path = "/EP")
public class EduProgramController {
    @Autowired
    private EduProgramService service;
    @PostMapping
    public ResponseEntity<HttpStatus> EduProgram(@RequestBody EduProgramDTO dto){
        if(dto != null){
            service.createEduProgram(dto);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/hello")//("/{id}")
    public String EduProgram(//@PathVariable String id)
    ){
//        if(service.getEduProgram(id) != null) return new ResponseEntity<>(HttpStatus.FOUND);
//        else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return "Hello!";
    }
}
