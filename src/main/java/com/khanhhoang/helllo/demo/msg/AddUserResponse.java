package com.khanhhoang.helllo.demo.msg;

import com.khanhhoang.helllo.model.UserEntity;
import com.khanhhoang.helllo.msg.BaseResponse;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddUserResponse extends BaseResponse {
    private UserEntity user;
}
