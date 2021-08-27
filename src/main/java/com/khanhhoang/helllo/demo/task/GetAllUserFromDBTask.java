package com.khanhhoang.helllo.demo.task;

import com.khanhhoang.helllo.demo.msg.GetAllUserRequest;
import com.khanhhoang.helllo.demo.msg.GetAllUserResponse;
import com.khanhhoang.helllo.service.UserService;
import com.khanhhoang.helllo.task.AbstractTask;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("GetAllUserFromDBTask")
public class GetAllUserFromDBTask extends AbstractTask<GetAllUserRequest, GetAllUserResponse> {

    private final UserService userService;

    public GetAllUserFromDBTask(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void behaviors(GetAllUserRequest request, GetAllUserResponse response) {
        response.setUsers(userService.getUsers());
    }
}
