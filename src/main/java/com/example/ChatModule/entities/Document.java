package com.example.ChatModule.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "DOCUMENTS")
@NonNull
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "doc_id")
    private Long id;
    @Column(name = "doc_content")
    private String content;
    @ManyToOne(optional = false)
    private Graduate graduate;
}