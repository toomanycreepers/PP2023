package com.example.ChatModule.repositories;

import com.example.ChatModule.entities.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> {
    Optional<Admin> findByName(String name);
    boolean existsByName(String name);
}
