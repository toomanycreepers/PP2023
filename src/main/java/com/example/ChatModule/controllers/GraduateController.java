package com.example.ChatModule.controllers;

import com.example.ChatModule.DTOs.DocumentDTO;
import com.example.ChatModule.DTOs.GraduateAuthDTO;
import com.example.ChatModule.DTOs.GraduateRegistrationDTO;
import com.example.ChatModule.services.GraduateService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

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

    @PostMapping(name="/pic",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<HttpStatus> setImage(@RequestPart("content") MultipartFile picture,@RequestParam("graduateId") long graduateId){
        try {
            byte[] content = picture.getBytes();
            if (service.uploadImage(graduateId,content)) {
                return new ResponseEntity<>(HttpStatus.CREATED);
            }
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        catch (IOException e)
        {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(name="/{gradId}/pic")
    public ResponseEntity<HttpStatus> deleteImage(@PathVariable long gradId){
        if (service.deleteImage(gradId)){
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping(name="/{gradId}/pic",produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<byte[]> getImage(@PathVariable long gradId){
        byte[] image = service.getGradImage(gradId);
        if (image==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDisposition(ContentDisposition.builder("attachment").filename("PFP").build());
        return ResponseEntity.ok().headers(headers).body(image);
    }
}
