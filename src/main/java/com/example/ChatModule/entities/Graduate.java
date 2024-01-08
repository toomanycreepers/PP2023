package com.example.ChatModule.entities;


import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCrypt;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Класс, представляющий абитуриента.
 */
@Entity
@Table(name = "Graduates")
@NonNull
@Getter
@NoArgsConstructor
public class Graduate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "grad_id")
    private long id;
    @Setter
    @Column(name = "grad_mail")
    private String mail;
    @Column(name = "grad_pw")
    private String password;
    @Setter
    @Column(name = "fname")
    private String firstname;
    @Setter
    @Column(name = "lname")
    private String lastname;
    @Setter
    @Column(name = "patronimic")
    private String patronimic;
    @Setter
    @DateTimeFormat
    @Column(name = "dob")
    private LocalDate dateOfBirth;
    @Column(name = "photo")
    @Lob
    @Setter
    private byte[] photo;
    @Setter
    @Column(name = "graduated_from")
    private String gradFrom;
    @Setter
    @Column(name = "living_region")
    private String region;
    @Column(name="salt")
    private String salt;
//    @Transient
//    private List<GrantedAuthority> roles = new ArrayList<GrantedAuthority>();
    @Transient
    private List<Role> role = new ArrayList<Role>();
    private void generateSalt(){
        if (this.salt==null)
            this.salt=BCrypt.gensalt();
    }
    public void setPassword(String password) {
        generateSalt();
        password=BCrypt.hashpw(password,salt);
        this.password=password;
    }

    public List<Role> getRoles(){
        role.add(new Role("ROLE_GRAD")) ;
       return role;
    }
}
