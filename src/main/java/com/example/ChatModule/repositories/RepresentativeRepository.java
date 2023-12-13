package com.example.ChatModule.repositories;

import com.example.ChatModule.entities.Representative;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RepresentativeRepository extends JpaRepository<Representative, Integer> {
    Optional<Representative> findByLogin(String login);
}
