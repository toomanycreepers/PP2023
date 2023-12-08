package services;

import DTOs.EduProgramDTO;
import entities.EduProgram;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EduProgramService {
    void createEduProgram(EduProgramDTO dto);
    EduProgramDTO getEduProgram(String id);
    EduProgramDTO getEduProgramByName(String name);
    //List<EduProgramDTO> getByFaculty(long faculty);
    void updateEduProgram(EduProgramDTO dto);
    void deleteEduProgram(String id);
}
