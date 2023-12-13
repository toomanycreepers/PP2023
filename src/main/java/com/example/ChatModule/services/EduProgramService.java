package com.example.ChatModule.services;

import com.example.ChatModule.DTOs.EduProgramDTO;

public interface EduProgramService {
    void createEduProgram(EduProgramDTO dto);
    EduProgramDTO getEduProgram(String id);
    EduProgramDTO getEduProgramByName(String name);
    //List<EduProgramDTO> getByFaculty(long faculty);
    void updateEduProgram(EduProgramDTO dto);
    void deleteEduProgram(String id);
}
