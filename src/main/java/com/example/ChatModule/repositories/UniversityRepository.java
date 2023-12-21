package com.example.ChatModule.repositories;

import com.example.ChatModule.entities.University;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UniversityRepository extends JpaRepository<University, Integer> {
    Optional<University> findByName(String name);
    boolean existsByName(String name);
}
