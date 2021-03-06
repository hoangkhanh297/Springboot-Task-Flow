package com.khanhhoang.helllo.demo.msg;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class AddUserRequest {
    private String name;
    private int status;
    private String username;
    private String password;
    private List<String> roles;

}
