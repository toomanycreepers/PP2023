package com.example.ChatModule.controllers;

import com.example.ChatModule.DTOs.GraduateAuthDTO;
import com.example.ChatModule.DTOs.GraduateRegistrationDTO;
import com.example.ChatModule.services.GraduateService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/grad")
public class GraduateController {
    @Autowired
    private GraduateService service;
    private static final Logger logger = LoggerFactory.getLogger(GraduateController.class);

    @GetMapping("/hello")
    @PreAuthorize("hasRole('GRAD')")
    public String hello(){
        return "<h1>hello, grad!!</h1>";
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> killGrad(@PathVariable long id){
        if (service.killGrad(id)){
            logger.info("Удалён абитуриент {}.", id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        logger.error("Ошибка удаления абитуриента {}.", id);
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PostMapping(value="/pic",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
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

    @DeleteMapping(value="/{gradId}/pic")
    public ResponseEntity<HttpStatus> deleteImage(@PathVariable long gradId){
        if (service.deleteImage(gradId)){
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping(value="/{gradId}/pic",produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<byte[]> getImage(@PathVariable long gradId){
        byte[] image = service.getGradImage(gradId);
        if (image==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_JPEG);
        headers.setContentDisposition(ContentDisposition.builder("attachment").filename("PFP.jpeg").build());
        return ResponseEntity.ok().headers(headers).body(image);
    }
}
