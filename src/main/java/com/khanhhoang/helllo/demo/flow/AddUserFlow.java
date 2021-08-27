package com.khanhhoang.helllo.demo.flow;

import com.khanhhoang.helllo.demo.msg.AddUserRequest;
import com.khanhhoang.helllo.demo.msg.AddUserResponse;
import com.khanhhoang.helllo.flow.AbstractFlow;
import com.khanhhoang.helllo.task.Task;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Qualifier("AddUserFlow")
public class AddUserFlow extends AbstractFlow<AddUserRequest, AddUserResponse> {
    private final Task<AddUserRequest, AddUserResponse> validateTask;
    private final Task<AddUserRequest, AddUserResponse> addUserTask;

    public AddUserFlow(@Qualifier("ValidateAddUserReqTask") Task<AddUserRequest, AddUserResponse> validateTask,
                       @Qualifier("AddUserToDBTask") Task<AddUserRequest, AddUserResponse> addUserTask) {
        this.validateTask = validateTask;
        this.addUserTask = addUserTask;
    }

    @Override
    protected List<Task<AddUserRequest, AddUserResponse>> listTasks() {
        List<Task<AddUserRequest, AddUserResponse>> tasks = new ArrayList<>();
        tasks.add(validateTask);
        tasks.add(addUserTask);
        return tasks;
    }
}
