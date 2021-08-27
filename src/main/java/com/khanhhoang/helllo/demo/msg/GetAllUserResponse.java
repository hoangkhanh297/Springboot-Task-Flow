package com.khanhhoang.helllo.demo.msg;

import com.khanhhoang.helllo.model.UserEntity;
import com.khanhhoang.helllo.msg.BaseResponse;

import java.util.List;

public class GetAllUserResponse extends BaseResponse {
    private List<UserEntity> users;

    public List<UserEntity> getUsers() {
        return users;
    }

    public void setUsers(List<UserEntity> users) {
        this.users = users;
    }
}
