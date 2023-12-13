package com.example.ChatModule.repositories;

import com.example.ChatModule.entities.Graduate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GraduateRepository extends JpaRepository<Graduate, Long> {
    Optional<Graduate> findByMail(String mail);
    List<Graduate> findByRegion(String region);
}
