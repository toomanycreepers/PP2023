package entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import org.springframework.data.annotation.Id;

import java.util.List;

@Data
@Entity
@Table(name = "Faculties")
@NonNull
@AllArgsConstructor
public class Faculty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "faculty_id")
    private long id;
    @Column(name = "faculty_name")
    private String name;
    @OneToOne
    @Column(name = "uni_id")
    private int university;
    @ManyToMany
//    @JoinTable(
//            name = "FacultyEP",
//            joinColumns = @JoinColumn(name = "faculty_id"),
//            inverseJoinColumns = @JoinColumn(name = "ep_id")
//    )
    private List<EduProgram> eduPrograms;
}
