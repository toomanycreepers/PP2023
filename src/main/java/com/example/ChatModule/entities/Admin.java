package com.example.ChatModule.entities;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.crypto.bcrypt.BCrypt;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Admins")
@NoArgsConstructor
@Getter
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "password")
    private String password;

    @Column(name = "salt")
    private String salt;
    @Transient
    private List<Role> role = new ArrayList<Role>();

    public List<Role> getRoles(){
        role.add(new Role("ROLE_ADMIN")) ;
        return role;
    }

    private void generateSalt(){
        if (this.salt==null)
            this.salt= BCrypt.gensalt();
    }

    private void setPassword(String password) {
        generateSalt();
        password=BCrypt.hashpw(password,salt);
        this.password=password;
    }

    public Admin(String name, String password){
        this.name = name;
        setPassword(password);
    }
}
