package com.example.ChatModule.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Documents")
@NonNull
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "doc_id")
    private Long id;
    @Setter
    @Column(name = "doc_content")
    @Lob
    private byte[] content;
    @Setter
    @Column(name="doc_name")
    private String name;
    @Setter
    @ManyToOne(optional = false)
    @JoinColumn(name="grad_id")
    private Graduate graduate;
}