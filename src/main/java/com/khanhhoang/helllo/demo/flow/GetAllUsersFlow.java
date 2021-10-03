package com.khanhhoang.helllo.demo.flow;

import com.khanhhoang.helllo.demo.msg.GetAllUserRequest;
import com.khanhhoang.helllo.flow.AbstractFlow;
import com.khanhhoang.helllo.task.Task;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("GetAllUsersFlow")
public class GetAllUsersFlow extends AbstractFlow<GetAllUserRequest> {

    public GetAllUsersFlow(@Qualifier("ValidateGetAllUserReqTask") Task<GetAllUserRequest> validateGetAllRqTask,
                           @Qualifier("GetAllUserFromDBTask") Task<GetAllUserRequest> getAllUserTask) {
        addTask(validateGetAllRqTask, false);
        addTask(getAllUserTask, true);
    }

}
