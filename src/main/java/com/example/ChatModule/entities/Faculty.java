package com.example.ChatModule.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Faculties")
@NonNull
@AllArgsConstructor
@Getter
public class Faculty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "faculty_id")
    private Long id;
    @Setter
    @Column(name = "faculty_name")
    private String name;
    @Setter
    @ManyToOne(optional = false)
    @JoinColumn(name = "uni_id")
    private University university;
    @ManyToMany
    @JoinTable(name="FacultyEP",joinColumns = @JoinColumn(name="faculty_id"),inverseJoinColumns = @JoinColumn(name="ep_id"))
    private ArrayList<EduProgram> eduPrograms;

    public Faculty(){
        this.id = null;
        this.name=null;
        this.university=null;
        this.eduPrograms = new ArrayList<>();
    }

    public void addEP(EduProgram ep){
        if (!eduPrograms.contains(ep)) eduPrograms.add(ep);
    }

    public void removeEP(EduProgram ep){
        eduPrograms.remove(ep);
    }
}
