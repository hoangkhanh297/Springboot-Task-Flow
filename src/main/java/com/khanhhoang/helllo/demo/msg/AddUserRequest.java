package com.khanhhoang.helllo.demo.msg;

import com.khanhhoang.helllo.msg.BaseRequest;

public class AddUserRequest extends BaseRequest {
    private String name;
    private int status;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
