package com.example.ChatModule.security;

import com.example.ChatModule.DTOs.AdminAuthRegDTO;
import com.example.ChatModule.DTOs.GraduateAuthDTO;
import com.example.ChatModule.DTOs.JwtResponse;
import com.example.ChatModule.DTOs.RepresentativeAuthDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.web.session.SessionSecurityMarker;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    @Autowired
    private AuthenticationManager authManager;
//    @Autowired
//    private AuthenticationManager authManager;
    @Autowired
    private JwtService jwtService;
    @Autowired
    private UserDetailServiceImpl userDetailService;

    public ResponseEntity<JwtResponse> createGradAuthToken(GraduateAuthDTO dto) {
//        UserDetails userDetails = userDetailService.loadUserByUsername(dto.getEmail());
//        Authentication auth =  new UsernamePasswordAuthenticationToken(userDetails.getUsername(), userDetails.getPassword());
////            try {
////                Authentication authenticate = authManager.authenticate(new UsernamePasswordAuthenticationToken(userDetails.getUsername(), userDetails.getPassword()));
////                if (authenticate.isAuthenticated())
////                    SecurityContextHolder.getContext().setAuthentication(authenticate);}
//        try{
//            authManager.authenticate(auth);
//        }
//                catch(Exception e){
//                System.out.print(e);
//            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
//        }
//
//
//        String token = jwtService.generateToken(userDetails);
//        return ResponseEntity.ok(new JwtResponse(token));
        try {
            authManager.authenticate(new UsernamePasswordAuthenticationToken(dto.getEmail(), dto.getPassword()));
        } catch(Exception e){
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }

        UserDetails userDetails = userDetailService.loadUserByUsername(dto.getEmail());
        String token = jwtService.generateToken(userDetails);
        System.out.println(userDetails.getUsername() + " in auth service!");
        SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken(dto.getEmail(), dto.getPassword()));

        return ResponseEntity.ok(new JwtResponse(token));
    }

    public ResponseEntity<JwtResponse> createRepAuthToken(RepresentativeAuthDTO dto) {
        try {
            authManager.authenticate(new UsernamePasswordAuthenticationToken(dto.getLogin(), dto.getPassword()));
        } catch(Exception e){
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }

        UserDetails userDetails = userDetailService.loadUserByUsername(dto.getLogin());
        String token = jwtService.generateToken(userDetails);
        return ResponseEntity.ok(new JwtResponse(token));
    }

    public ResponseEntity<JwtResponse> createAdminAuthToken(AdminAuthRegDTO dto) {
        try {
            authManager.authenticate(new UsernamePasswordAuthenticationToken(dto.getName(), dto.getPassword()));
        } catch(Exception e){
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }

        UserDetails userDetails = userDetailService.loadUserByUsername(dto.getName());
        String token = jwtService.generateToken(userDetails);
        return ResponseEntity.ok(new JwtResponse(token));
    }
}
