package com.khanhhoang.helllo.controller;

import com.khanhhoang.helllo.authen.JwtUtil;
import com.khanhhoang.helllo.demo.msg.AuthenticationRequest;
import com.khanhhoang.helllo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class AuthenticationController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private JwtUtil jwtUtil;


    @PostMapping(value = "/login", produces = {MediaType.APPLICATION_JSON_VALUE})
    public Object login(@RequestBody AuthenticationRequest authenticationRequest) {
        var user = userRepository.findByUsernameAndPassword(authenticationRequest.getUsername(), authenticationRequest.getPassword());
        if (user.isEmpty()) {
            return null;
        }
        return jwtUtil.generateToken(user.get());
    }


}
