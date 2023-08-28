package com.intech.session6.controller;

import com.intech.session6.dto.JwtRequest;
import com.intech.session6.dto.JwtResponse;
import com.intech.session6.security.JwtHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth/login")
public class AuthController {
    @Autowired
    AuthenticationManager manager;
    @Autowired
    JwtHelper jwtHelper;
    @Autowired
    UserDetailsService userDetailsService;
    @PostMapping("")
    public ResponseEntity<JwtResponse> auth(@RequestBody JwtRequest request){
        doAuthenticate(request.getUsername(),request.getPassword());
        UserDetails userDetails=userDetailsService.loadUserByUsername(request.getUsername());
        String toke=jwtHelper.generateToken(userDetails);
        JwtResponse response=JwtResponse.builder()
                .jwtToken(toke)
                .username(userDetails.getUsername())
                .build();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    private void doAuthenticate(String username, String password) {
        UsernamePasswordAuthenticationToken authenticationToken=new UsernamePasswordAuthenticationToken(username,password);
        manager.authenticate(authenticationToken);
    }
}
