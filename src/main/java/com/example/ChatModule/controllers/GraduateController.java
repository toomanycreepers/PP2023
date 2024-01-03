package com.example.ChatModule.controllers;

import com.example.ChatModule.DTOs.GraduateAuthDTO;
import com.example.ChatModule.DTOs.GraduateRegistrationDTO;
import com.example.ChatModule.services.GraduateService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/grad")
public class GraduateController {
    @Autowired
    GraduateService service;

    @PostMapping("/auth")
    public ResponseEntity<HttpStatus> checkPW(@Valid @RequestBody GraduateAuthDTO dto){
        if(service.authenticateGrad(dto)) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/register")
    public ResponseEntity<HttpStatus> registerGrad(@Valid @RequestBody GraduateRegistrationDTO dto){
            if (service.registerGraduate(dto)){
                return new ResponseEntity<>(HttpStatus.OK);
            }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> killGrad(@PathVariable long id){
        if (service.killGrad(id)){
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
