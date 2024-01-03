package com.example.ChatModule.controllers;

import com.example.ChatModule.DTOs.EduProgramDTO;
import com.example.ChatModule.DTOs.RepresentativeAuthDTO;
import com.example.ChatModule.DTOs.RepresentativeRegistrationDTO;
import com.example.ChatModule.services.RepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rep")
public class RepresentativeController {
    @Autowired
    RepService service;

    @PostMapping("/auth")
    public ResponseEntity<HttpStatus> CheckPW(@RequestBody RepresentativeAuthDTO dto){
        if(service.authenticateRep(dto)){
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/register")
    public ResponseEntity<HttpStatus> RegisterRep(@RequestBody RepresentativeRegistrationDTO dto){
        if (service.registerRep(dto)) {
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/{repLogin}/programs")
    public ResponseEntity<HttpStatus> addEP(@PathVariable String repLogin, @RequestBody EduProgramDTO dto){
        if(service.addEP(repLogin,dto.getId())){
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/{repLogin}/programs/{programId}")
    public ResponseEntity<HttpStatus> removeEP(@PathVariable String repLogin, @PathVariable String programId){
        if(service.removeEP(repLogin,programId)) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    @DeleteMapping("/{repId}")
    public ResponseEntity<HttpStatus> killRep(@PathVariable int repId){
        if(service.killRep(repId)) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
