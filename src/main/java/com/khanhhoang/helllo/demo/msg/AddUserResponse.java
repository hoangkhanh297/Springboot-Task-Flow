package com.khanhhoang.helllo.demo.msg;

import com.khanhhoang.helllo.model.UserEntity;
import com.khanhhoang.helllo.msg.BaseResponse;

public class AddUserResponse extends BaseResponse {
    private UserEntity user;

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }
}
