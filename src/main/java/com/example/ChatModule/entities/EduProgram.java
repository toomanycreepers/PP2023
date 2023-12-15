package com.example.ChatModule.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "EducationPrograms")
@NonNull
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EduProgram {
    @Id
    @Column(name = "ep_id")
    private String id;
    @Column(name = "ep_name")
    private String name;
}
