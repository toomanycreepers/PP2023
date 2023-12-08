package entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import org.springframework.data.annotation.Id;

@Data
@Entity
@Table(name = "Representatives")
@NonNull
@AllArgsConstructor
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
    @ManyToOne
    @Column(name = "uni_id")
    private int university;
}
