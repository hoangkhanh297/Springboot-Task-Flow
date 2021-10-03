package com.khanhhoang.helllo.demo.flow;

import com.khanhhoang.helllo.demo.msg.AddUserRequest;
import com.khanhhoang.helllo.flow.AbstractFlow;
import com.khanhhoang.helllo.task.Task;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("AddUserFlow")
public class AddUserFlow extends AbstractFlow<AddUserRequest> {

    public AddUserFlow(@Qualifier("ValidateAddUserReqTask") Task<AddUserRequest> validateTask,
                       @Qualifier("AddUserToDBTask") Task<AddUserRequest> addUserTask) {
        addTask(validateTask, false);
        addTask(addUserTask, false);
    }
}
