package com.example.ChatModule.controllers;

import com.example.ChatModule.DTOs.GraduateAuthDTO;
import com.example.ChatModule.DTOs.GraduateRegistrationDTO;
import com.example.ChatModule.services.impl.GraduateServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/grad")
public class GraduateController {
    @Autowired
    GraduateServiceImpl service;
    @PostMapping("/auth")
    public ResponseEntity<HttpStatus> CheckPW(@RequestBody GraduateAuthDTO dto){
        if(service.authenticateGrad(dto)) return new ResponseEntity<>(HttpStatus.OK);
        else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PostMapping("/register")
    public ResponseEntity<HttpStatus> RegisterGrad(@RequestBody GraduateRegistrationDTO dto){
        if (!service.mailPresent(dto.getMail())) {
            service.registerGraduate(dto);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
