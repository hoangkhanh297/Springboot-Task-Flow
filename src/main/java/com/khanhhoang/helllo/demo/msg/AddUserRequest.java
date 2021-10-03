package com.khanhhoang.helllo.demo.msg;

import com.khanhhoang.helllo.model.UserEntity;
import com.khanhhoang.helllo.msg.BaseRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class AddUserRequest extends BaseRequest {
    private String name;
    private int status;
    private String username;
    private String password;
    private List<String> roles;

    private UserEntity response;

}
