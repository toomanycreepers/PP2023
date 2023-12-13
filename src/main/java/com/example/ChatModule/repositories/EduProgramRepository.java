package com.example.ChatModule.repositories;

import com.example.ChatModule.entities.EduProgram;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EduProgramRepository extends JpaRepository<EduProgram, String> {
    Optional<EduProgram> findByName(String name);
}
