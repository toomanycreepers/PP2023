package entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

import java.util.List;

@Data
@Entity
@Table(name = "EducationPrograms")
@NonNull
@AllArgsConstructor
public class EduProgram {
    @Id
    @Column(name = "ep_id")
    private String id;
    @Column(name = "ep_name")
    private String name;
    @ManyToMany(mappedBy = "eduPrograms")
    private List<Long> faculties; //потом подумаем
}
