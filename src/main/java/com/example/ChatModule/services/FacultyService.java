package com.example.ChatModule.services;

import com.example.ChatModule.DTOs.EduProgramDTO;
import com.example.ChatModule.DTOs.FacultyCreationDTO;
import com.example.ChatModule.DTOs.FacultyDTO;
import com.example.ChatModule.DTOs.FacultyEPDTO;
import com.example.ChatModule.entities.EduProgram;
import com.example.ChatModule.entities.Faculty;
import com.example.ChatModule.repositories.EduProgramRepository;
import com.example.ChatModule.repositories.FacultyRepository;
import com.example.ChatModule.repositories.UniversityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FacultyService {
    @Autowired
    private FacultyRepository repo;
    @Autowired
    private UniversityRepository uniRepo;
    @Autowired
    private EduProgramRepository epRepo;

    public FacultyDTO findById(long id){
        Faculty fac = repo.findById(id).orElse(null);
        if (fac==null) return null;
        return new FacultyDTO(fac);
    }

    public void createFaculty(FacultyCreationDTO dto){
        Faculty faculty = new Faculty();
        faculty.setName(dto.getName());
        faculty.setUniversity(uniRepo.findById(dto.getUniId()).get());
        repo.save(faculty);
    }

    public void addEP(long facultyId, String EPId) {
        Faculty faculty = repo.findById(facultyId).orElse(null);
        if (faculty==null) return;
        faculty.addEP(epRepo.findById(EPId).get());
        repo.save(faculty);
    }

    public void removeEP(long facultyId, String EPId){
        Faculty faculty = repo.findById(facultyId).orElse(null);
        if (faculty==null) return;
        faculty.removeEP(epRepo.findById(EPId).get());
        repo.save(faculty);
    }

    public FacultyEPDTO findAllEduPrograms(long facultyId){
        Faculty faculty = repo.findById(facultyId).orElse(null);
        if (faculty==null) return null;
        List<EduProgram> eps = faculty.getEduPrograms();
        ArrayList<EduProgramDTO> epdtos = new ArrayList<>();
        for (int i=0;i<eps.toArray().length;i++){
            epdtos.add(new EduProgramDTO(eps.get(i)));
        }
        return new FacultyEPDTO(faculty.getName(),epdtos);
    }

    public void removeFaculty(long facultyId){
        if (repo.existsById(facultyId)) repo.deleteById(facultyId);
    }
}