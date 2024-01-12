package com.example.ChatModule.controllers;

import com.example.ChatModule.DTOs.*;
import com.example.ChatModule.security.JwtService;
import com.example.ChatModule.security.AuthService;
import com.example.ChatModule.security.LogoutService;
import com.example.ChatModule.services.AdminService;
import com.example.ChatModule.services.GraduateService;
import com.example.ChatModule.services.RepService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.nio.file.Files;

@RestController
public class AuthController {
    @Autowired
    private GraduateService gradService;
    @Autowired
    private RepService repService;
    @Autowired
    private AdminService adminService;
    @Autowired
    private JwtService jwtService;
    @Autowired
    private AuthService authService;
    @Autowired
    private LogoutService logoutService;

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

    @PostMapping("/register/admin")
    public ResponseEntity<HttpStatus> RegisterAdmin(@Valid @RequestBody AdminAuthRegDTO dto){
        if (adminService.registerAdmin(dto)) {
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

    @PostMapping("/auth/admin")
    public ResponseEntity<?> createAdminAuthToken(@RequestBody AdminAuthRegDTO dto) {
        return authService.createAdminAuthToken(dto);
    }

    @GetMapping("/sign")
    @ResponseBody
    public ResponseEntity<?> getSignPage() throws IOException {
        Resource resource = new ClassPathResource("static/reg_auth.html");
        String htmlContent = new String(Files.readAllBytes(resource.getFile().toPath()));
        return ResponseEntity.ok().contentType(MediaType.TEXT_HTML).body(htmlContent);
    }

//    @GetMapping("/logout")
//    public ResponseEntity<?> logOut(){
//        logoutService.logout();
//    }

    @GetMapping("/admin/hello")
    @PreAuthorize("hasRole('ADMIN')")
    public String hello(){
        return "<h1>hello, admin!</h1>";
    }
}
