package com.example.ChatModule.repositories;

import com.example.ChatModule.entities.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DocumentsRepository extends JpaRepository<Document, Long> {
}
