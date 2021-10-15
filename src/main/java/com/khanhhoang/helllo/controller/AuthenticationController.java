package com.khanhhoang.helllo.controller;

import com.khanhhoang.helllo.authen.JwtUtil;
import com.khanhhoang.helllo.base.data.ResponseData;
import com.khanhhoang.helllo.base.data.ResultCode;
import com.khanhhoang.helllo.demo.msg.AuthenticationRequest;
import com.khanhhoang.helllo.demo.msg.AuthenticationResponse;
import com.khanhhoang.helllo.repository.UserRepository;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(value = "User APIs")
public class AuthenticationController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping(value = "/login", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseData<AuthenticationResponse> login(@RequestBody AuthenticationRequest authenticationRequest) {
        var user = userRepository.findByUsernameAndPassword(authenticationRequest.getUsername(), authenticationRequest.getPassword());
        if (user.isEmpty()) {
            return ResponseData.error(ResultCode.User.INVALID_LOGIN);
        }
        return ResponseData.ok(new AuthenticationResponse(jwtUtil.generateToken(user.get()), user.get()));
    }
}
