package com.example.ChatModule.repositories;

import com.example.ChatModule.entities.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FacultyRepository extends JpaRepository<Faculty, Long> {
    List<Faculty> findAllByName(String name);
    List<Faculty> findAllByUniversityId(int universityId);
}
