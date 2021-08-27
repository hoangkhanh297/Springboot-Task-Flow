package com.khanhhoang.helllo.demo.task;

import com.khanhhoang.helllo.demo.msg.AddUserRequest;
import com.khanhhoang.helllo.demo.msg.AddUserResponse;
import com.khanhhoang.helllo.model.UserEntity;
import com.khanhhoang.helllo.service.UserService;
import com.khanhhoang.helllo.task.AbstractTask;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("AddUserToDBTask")
public class AddUserToDBTask extends AbstractTask<AddUserRequest, AddUserResponse> {

    private final UserService userService;

    public AddUserToDBTask(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void behaviors(AddUserRequest request, AddUserResponse response) {
        var user = new UserEntity();
        user.setName(request.getName());
        user.setStatus(request.getStatus());
        userService.addUser(user);
        log.info("Add user");
        response.setUser(user);
    }
}
