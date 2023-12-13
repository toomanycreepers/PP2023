package com.example.ChatModule.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "FACULTIES")
@NonNull
@AllArgsConstructor
@NoArgsConstructor
public class Faculty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "faculty_id")
    private long id;
    @Column(name = "faculty_name")
    private String name;
    @ManyToOne(optional = false)
    //@Column(name = "uni_id")
    private University university;
    @ManyToMany
    private ArrayList<EduProgram> eduPrograms;
}
