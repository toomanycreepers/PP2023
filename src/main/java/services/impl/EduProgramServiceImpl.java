package services.impl;

import DTOs.EduProgramDTO;
import entities.EduProgram;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.EduProgramRepository;
import services.EduProgramService;

import java.util.List;

public class EduProgramServiceImpl implements EduProgramService {
    @Autowired
    private EduProgramRepository repository;
    public void createEduProgram(EduProgramDTO dto){
        repository.save(new EduProgram(
                dto.getId(),
                dto.getName(),
                dto.getFaculty()
        ));
    }
    public EduProgramDTO getEduProgram(String id){
        var foundEP = repository.findById(id).orElse(null);
        if(foundEP != null) return new EduProgramDTO(
                foundEP.getId(),
                foundEP.getName(),
                foundEP.getFaculties()
        );
        else return null;
    }
    public EduProgramDTO getEduProgramByName(String name){
        var foundEP = repository.findByName(name).orElse(null);
        if(foundEP != null) return new EduProgramDTO(
                foundEP.getId(),
                foundEP.getName(),
                foundEP.getFaculties()
        );
        else return null;
    }
//    public List<EduProgramDTO> getByFaculty(long faculty){
//
//    }
    public void updateEduProgram(EduProgramDTO dto){
        var EPToUpdate = repository.findById(dto.getId()).orElse(null);
        EPToUpdate.setId(dto.getId());
        EPToUpdate.setName(dto.getName());
        EPToUpdate.setFaculties(dto.getFaculty());
        repository.save(EPToUpdate);
    }
    public void deleteEduProgram(String id){
        repository.deleteById(id);
    }
}
