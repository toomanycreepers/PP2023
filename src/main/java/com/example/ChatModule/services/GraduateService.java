package com.example.ChatModule.services;

import com.example.ChatModule.DTOs.GraduateAuthDTO;
import com.example.ChatModule.DTOs.GraduateRegistrationDTO;
import com.example.ChatModule.entities.Graduate;
import com.example.ChatModule.repositories.GraduateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class GraduateService {
    @Autowired
    private GraduateRepository repo;

    public boolean registerGraduate(GraduateRegistrationDTO dto){
        boolean mailPresent = mailPresent(dto.getMail());
        if (mailPresent) return false;
        var grad = new Graduate();
        grad.setMail(dto.getMail());
        grad.setPassword(dto.getPassword());
        grad.setFirstname(dto.getFirstname());
        grad.setLastname(dto.getLastname());
        grad.setPatronimic(dto.getPatronimic());
        grad.setDateOfBirth(LocalDate.parse(dto.getDateOfBirth()));
        grad.setGradFrom(dto.getGradFrom());
        grad.setRegion(dto.getRegion());
        repo.save(grad);
        return mailPresent(dto.getMail());
    }

    public boolean authenticateGrad(GraduateAuthDTO dto){
        Graduate grad = repo.findByMail(dto.getMail()).orElse(null);
        return(grad!=null&&grad.getPassword().equals(BCrypt.hashpw(dto.getPassword(),grad.getSalt())));
    }

    public boolean mailPresent(String mail){
        return repo.existsByMail(mail);
    }

    public boolean killGrad(long id){
        boolean exists = repo.existsById(id);
        repo.deleteById(id);
        return exists;
    }
}
