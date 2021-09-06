package com.khanhhoang.helllo.demo.msg;

import com.khanhhoang.helllo.msg.BaseRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class AddUserRequest extends BaseRequest {
    private String name;
    private int status;

}
