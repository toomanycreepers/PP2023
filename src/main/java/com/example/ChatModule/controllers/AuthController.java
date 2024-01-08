package com.example.ChatModule.controllers;

import com.example.ChatModule.DTOs.GraduateAuthDTO;
import com.example.ChatModule.DTOs.GraduateRegistrationDTO;
import com.example.ChatModule.DTOs.RepresentativeAuthDTO;
import com.example.ChatModule.DTOs.RepresentativeRegistrationDTO;
import com.example.ChatModule.security.JwtService;
import com.example.ChatModule.security.AuthService;
import com.example.ChatModule.services.GraduateService;
import com.example.ChatModule.services.RepService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("/auth") по скольку есть /register и есть /auth, и методов немного, пока что у всех свои пути(чтобы не было /auth/register)
public class AuthController {
    @Autowired
    private GraduateService gradService;
    @Autowired
    private RepService repService;
    @Autowired
    private JwtService jwtService;
    @Autowired
    private AuthService authService;

    @PostMapping("/register/grad")
    public ResponseEntity<HttpStatus> registerGrad(@Valid @RequestBody GraduateRegistrationDTO dto){
        if (gradService.registerGraduate(dto)){
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/register/rep")
    public ResponseEntity<HttpStatus> RegisterRep(@Valid @RequestBody RepresentativeRegistrationDTO dto){
        if (repService.registerRep(dto)) {
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/auth/rep")
    public ResponseEntity<?> createRepAuthToken(@RequestBody RepresentativeAuthDTO dto) {
        return authService.createRepAuthToken(dto);
    }
    @PostMapping("/auth/grad")
    public ResponseEntity<?> createGradAuthToken(@RequestBody GraduateAuthDTO dto) {
        return authService.createGradAuthToken(dto);
    }


}
