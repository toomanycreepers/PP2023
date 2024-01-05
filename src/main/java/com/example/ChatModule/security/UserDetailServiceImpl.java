package com.example.ChatModule.security;

import com.example.ChatModule.entities.Graduate;
import com.example.ChatModule.entities.Representative;
import com.example.ChatModule.repositories.GraduateRepository;
import com.example.ChatModule.repositories.RepresentativeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserDetailServiceImpl implements UserDetailsService {
    @Autowired
    private GraduateRepository gradRepo;
    @Autowired
    private RepresentativeRepository repRepo;

    @Override
    public UserDetails loadUserByUsername(String mail){
        Graduate grad = gradRepo.findByMail(mail).orElse(null);
        if(grad == null) throw new UsernameNotFoundException("User with" + mail + " mail not found");

        return new org.springframework.security.core.userdetails.User(
                grad.getMail(),
                grad.getPassword(),
                grad.getRoles().stream().map(role -> new SimpleGrantedAuthority(role.getAuthority())).collect(Collectors.toList())
        );


    }
    public UserDetails loadRepresentativeByLogin(String login){
        Representative rep = repRepo.findByLogin(login).orElse(null);
        if(rep == null) throw new UsernameNotFoundException("User with" + login + " login not found");

        return new org.springframework.security.core.userdetails.User(
                rep.getLogin(),
                rep.getPassword(),
                rep.getRoles().stream().map(role -> new SimpleGrantedAuthority(role.getAuthority())).collect(Collectors.toList())
        );
    }
}
