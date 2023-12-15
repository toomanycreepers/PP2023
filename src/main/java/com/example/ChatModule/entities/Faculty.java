package com.example.ChatModule.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Faculties")
@NonNull
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Faculty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "faculty_id")
    private Long id;
    @Column(name = "faculty_name")
    private String name;
    @ManyToOne(optional = false)
    @JoinColumn(name = "uni_id")
    private University university;
    @ManyToMany
    @JoinTable(name="FacultyEP",joinColumns = @JoinColumn(name="faculty_id"),inverseJoinColumns = @JoinColumn(name="ep_id"))
    private ArrayList<EduProgram> eduPrograms;
}
