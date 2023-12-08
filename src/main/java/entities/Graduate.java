package entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "Graduates")
@NonNull
@AllArgsConstructor
public class Graduate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "grad_id")
    private long id;
    @Column(name = "grad_mail")
    private String mail;
    @Column(name = "grad_pw")
    private String password;
    @Column(name = "fname")
    private String firstname;
    @Column(name = "lname")
    private String lastname;
    @Column(name = "patronimic")
    private String patronimic;
    @DateTimeFormat
    @Column(name = "dob")
    private LocalDateTime dateOfBirthday;
    @Column(name = "photo")
    private String photo;
    @Column(name = "graduated_from")
    private String gradFrom;
    @Column(name = "living_region")
    private String region;
}
