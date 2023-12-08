package entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import org.springframework.data.annotation.Id;

@Data
@Entity
@Table(name = "Documents")
@NonNull
@AllArgsConstructor
public class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "doc_id")
    private long id;
    @Column(name = "doc_content")
    private String content;
    @ManyToOne
    @Column(name = "grad_id")
    private long graduate;
}
