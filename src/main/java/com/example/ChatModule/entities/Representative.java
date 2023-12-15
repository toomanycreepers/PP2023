package com.example.ChatModule.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.ArrayList;

@Entity
@Table(name = "Representatives")
@NonNull
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Representative {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rep_id")
    private int id;
    @Column(name = "rep_login")
    private String login;
    @Column(name = "rep_pw")
    private String password;
    @Column(name = "fname")
    private String firstname;
    @Column(name = "lname")
    private String lastname;
    @Column(name = "patronimic")
    private String patronimic;
    @ManyToOne(optional = false)
    @JoinColumn(name = "uni_id")
    private University university;
    @ManyToMany
    @JoinTable(name="RepresentativeEP",joinColumns = @JoinColumn(name="rep_id"),inverseJoinColumns = @JoinColumn(name="ep_id"))
    private ArrayList<EduProgram> eduPrograms;
}
