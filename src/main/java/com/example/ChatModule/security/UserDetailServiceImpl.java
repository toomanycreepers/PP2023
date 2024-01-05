package com.example.ChatModule.security;

import com.example.ChatModule.entities.Graduate;
import com.example.ChatModule.repositories.GraduateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailServiceImpl implements UserDetailsService {
    @Autowired
    private GraduateRepository repo;

    @Override
    public UserDetails loadUserByUsername(String mail){
        Graduate grad = repo.findByMail(mail).orElse(null);
        if(grad == null) throw new UsernameNotFoundException("User with" + mail + "not found");

        return org.springframework.security.core.userdetails.User
                .withUsername(mail)
                .password(grad.getPassword())
                .authorities(grad.getRole())
                .accountExpired(false)
                .accountLocked(false)
                .credentialsExpired(false)
                .disabled(false)
                .build();
    }
}
