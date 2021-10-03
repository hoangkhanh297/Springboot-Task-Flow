package com.khanhhoang.helllo.demo.msg;

import com.khanhhoang.helllo.msg.BaseRequest;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthenticationRequest extends BaseRequest {
    private String username;
    private String password;
}
