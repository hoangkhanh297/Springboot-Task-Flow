package com.khanhhoang.helllo.demo.msg;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class GetAllUserRequest {
    private String requestId = UUID.randomUUID().toString();
}
