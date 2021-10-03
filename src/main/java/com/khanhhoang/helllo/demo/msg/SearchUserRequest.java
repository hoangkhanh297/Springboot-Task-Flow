package com.khanhhoang.helllo.demo.msg;

import com.khanhhoang.helllo.model.UserEntity;
import com.khanhhoang.helllo.msg.BaseRequest;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SearchUserRequest extends BaseRequest {
    private String text;
    private List<UserEntity> response;
}
