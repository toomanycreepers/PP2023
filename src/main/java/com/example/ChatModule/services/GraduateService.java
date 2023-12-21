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

    public void registerGraduate(GraduateRegistrationDTO dto){
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
    }

    public boolean authenticateGrad(GraduateAuthDTO dto){
        Graduate grad = repo.findByMail(dto.getMail()).orElse(null);
        return(grad!=null&&grad.getPassword().equals(BCrypt.hashpw(dto.getPassword(),grad.getSalt())));
    }

    public boolean mailPresent(String mail){
        Graduate grad = repo.findByMail(mail).orElse(null);
        return grad!=null;
    }

    public void killGrad(long id){
        if (repo.existsById(id)) repo.deleteById(id);
    }
}
