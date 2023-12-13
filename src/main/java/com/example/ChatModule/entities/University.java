package com.example.ChatModule.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Table(name = "UNIVERSITIES")
@NonNull
@AllArgsConstructor
@NoArgsConstructor
public class University {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "uni_id")
    private int id;
    @Column(name = "uni_name")
    private String name;
}
