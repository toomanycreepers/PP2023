package com.example.ChatModule.services;

import com.example.ChatModule.DTOs.EduProgramDTO;
import com.example.ChatModule.entities.EduProgram;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.ChatModule.repositories.EduProgramRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EduProgramService {
    @Autowired
    private EduProgramRepository repository;

    public boolean createEduProgram(@Valid EduProgramDTO dto){
        repository.save(new EduProgram(
                dto.getId(),
                dto.getName()
        ));
        return repository.existsById(dto.getId());
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

    public boolean updateEduProgram(@Valid EduProgramDTO dto){
        var EPToUpdate = repository.findById(dto.getId()).orElse(null);

        if (EPToUpdate!=null){
        EPToUpdate.setId(dto.getId());
        EPToUpdate.setName(dto.getName());
        repository.save(EPToUpdate);
        return true;
        }

        return false;
    }

    public boolean deleteEduProgram(String id){
        boolean exists = repository.existsById(id);
        repository.deleteById(id);
        return exists;
    }
}
