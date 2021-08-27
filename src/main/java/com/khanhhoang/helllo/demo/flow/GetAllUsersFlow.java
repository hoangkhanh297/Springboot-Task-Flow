package com.khanhhoang.helllo.demo.flow;

import com.khanhhoang.helllo.demo.msg.GetAllUserRequest;
import com.khanhhoang.helllo.demo.msg.GetAllUserResponse;
import com.khanhhoang.helllo.flow.AbstractFlow;
import com.khanhhoang.helllo.task.Task;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Qualifier("GetAllUsersFlow")
public class GetAllUsersFlow extends AbstractFlow<GetAllUserRequest, GetAllUserResponse> {
    private final Task<GetAllUserRequest, GetAllUserResponse> validateCalculateTask;
    private final Task<GetAllUserRequest, GetAllUserResponse> calculateTask;

    public GetAllUsersFlow(@Qualifier("GetAllUserFromDBTask") Task<GetAllUserRequest, GetAllUserResponse> validateCalculateTask,
                           @Qualifier("ValidateGetAllUserReqTask") Task<GetAllUserRequest, GetAllUserResponse> calculateTask) {
        this.validateCalculateTask = validateCalculateTask;
        this.calculateTask = calculateTask;
    }

    @Override
    protected List<Task<GetAllUserRequest, GetAllUserResponse>> listTasks() {
        List<Task<GetAllUserRequest, GetAllUserResponse>> tasks = new ArrayList<>();
        tasks.add(validateCalculateTask);
        tasks.add(calculateTask);
        return tasks;
    }
}
