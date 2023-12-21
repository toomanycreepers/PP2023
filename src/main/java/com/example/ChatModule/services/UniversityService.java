package com.example.ChatModule.services;

import com.example.ChatModule.DTOs.FacultyEPDTO;
import com.example.ChatModule.DTOs.UniversityCreationDTO;
import com.example.ChatModule.entities.Faculty;
import com.example.ChatModule.entities.University;
import com.example.ChatModule.repositories.FacultyRepository;
import com.example.ChatModule.repositories.UniversityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UniversityService {
    @Autowired
    private UniversityRepository repo;
    @Autowired
    private FacultyRepository facRepo;
    @Autowired
    private FacultyService facService;

    public void addUniversity(UniversityCreationDTO dto){
        if (!repo.existsByName(dto.getName())) repo.save(new University(null,dto.getName()));
    }

    public void removeUniversity(int id){
        if (repo.existsById(id)) repo.deleteById(id);
    }

    public List<FacultyEPDTO> getUniversityEPs(int uniId){
        List<Faculty> uniFacs = facRepo.findAllByUniversityId(uniId);
        var returnable = new ArrayList<FacultyEPDTO>();
        for (Faculty faculty: uniFacs) {
            returnable.add(facService.findAllEduPrograms(faculty.getId()));
        }
        return returnable;
    }
}
