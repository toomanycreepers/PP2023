package com.example.ChatModule.services;

import com.example.ChatModule.DTOs.EduProgramDTO;
import com.example.ChatModule.entities.EduProgram;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.ChatModule.repositories.EduProgramRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EduProgramService {
    @Autowired
    private EduProgramRepository repository;
    public void createEduProgram(EduProgramDTO dto){
        repository.save(new EduProgram(
                dto.getId(),
                dto.getName()
        ));
    }

    public List<EduProgramDTO> getAllEduPrograms(){
        ArrayList<EduProgram> programs = new ArrayList<>(repository.findAll());
        var dtos = new ArrayList<EduProgramDTO>();
        for (int i=0;i<programs.toArray().length;i++){
            EduProgram program = programs.get(i);
            dtos.add(new EduProgramDTO(program));
        }
        return dtos;
    }

    public EduProgramDTO getEduProgram(String id){
        var foundEP = repository.findById(id).orElse(null);
        if(foundEP != null) return new EduProgramDTO(foundEP);
        else return null;
    }
    public EduProgramDTO getEduProgramByName(String name){
        var foundEP = repository.findByName(name).orElse(null);
        if(foundEP != null) return new EduProgramDTO(foundEP);
        else return null;
    }

    public void updateEduProgram(EduProgramDTO dto){
        var EPToUpdate = repository.findById(dto.getId()).orElse(null);
        EPToUpdate.setId(dto.getId());
        EPToUpdate.setName(dto.getName());
        repository.save(EPToUpdate);
    }
    public void deleteEduProgram(String id){
        if (repository.existsById(id)) repository.deleteById(id);
    }
}
