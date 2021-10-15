package com.khanhhoang.helllo.demo.flow;

import com.khanhhoang.helllo.demo.task.GetAllUserFromDBTask;
import com.khanhhoang.helllo.demo.task.ValidateGetAllUserReqTask;
import com.khanhhoang.helllo.flow.AbstractFlow;
import com.khanhhoang.helllo.model.UserEntity;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Qualifier("GetAllUsersFlow")
public class GetAllUsersFlow extends AbstractFlow<Object, List<UserEntity>> {

    public GetAllUsersFlow(ValidateGetAllUserReqTask validateGetAllRqTask,
                           GetAllUserFromDBTask getAllUserTask) {
        addTask(validateGetAllRqTask, false);
        addTask(getAllUserTask, false);
    }

}
