package com.example.ChatModule.services;

import com.example.ChatModule.DTOs.RepresentativeAuthDTO;
import com.example.ChatModule.DTOs.RepresentativeRegistrationDTO;
import com.example.ChatModule.entities.Representative;
import com.example.ChatModule.repositories.EduProgramRepository;
import com.example.ChatModule.repositories.RepresentativeRepository;
import com.example.ChatModule.repositories.UniversityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;


@Service
public class RepService {
    @Autowired
    private RepresentativeRepository repo;
    @Autowired
    private UniversityRepository uniRepo;
    @Autowired
    private EduProgramRepository epRepo;

    public void registerRep(RepresentativeRegistrationDTO dto){
        var rep = new Representative();
        rep.setLogin(dto.getLogin());
        rep.setFirstname(dto.getFirstname());
        rep.setLastname(dto.getLastname());
        rep.setPatronimic(dto.getPatronimic());
        rep.setPassword(dto.getPassword());
        rep.setUniversity(uniRepo.findByName(dto.getUniName()).get());
        repo.save(rep);
    }

    public void killRep(int repId){
        if (repo.existsById(repId)) repo.deleteById(repId);
    }

    public boolean authenticateRep(RepresentativeAuthDTO dto){
        Representative rep = repo.findByLogin(dto.getLogin()).orElse(null);
        return( rep != null && rep.getPassword().equals(BCrypt.hashpw(dto.getPassword(),rep.getSalt())));
    }

    public boolean loginPresent(String login){
        Representative rep = repo.findByLogin(login).orElse(null);
        return rep!=null;
    }
    public void addEP(String repLogin, String EPId) {
        Representative rep = repo.findByLogin(repLogin).orElse(null);
        if (rep==null) return;
        rep.addEP(epRepo.findById(EPId).get());
        repo.save(rep);
    }

    public void removeEP(String repLogin, String EPId){
        Representative rep = repo.findByLogin(repLogin).orElse(null);
        if (rep==null) return;
        rep.removeEP(epRepo.findById(EPId).get());
        repo.save(rep);
    }

}
