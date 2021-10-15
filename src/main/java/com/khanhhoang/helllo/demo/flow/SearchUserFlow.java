package com.khanhhoang.helllo.demo.flow;

import com.khanhhoang.helllo.flow.AbstractFlow;
import com.khanhhoang.helllo.model.UserEntity;
import com.khanhhoang.helllo.task.Task;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Qualifier("SearchUserFlow")
public class SearchUserFlow extends AbstractFlow<String, List<UserEntity>> {
    public SearchUserFlow(@Qualifier("ValidateSearchRqTask") Task<String, List<UserEntity>> validateSearchRqTask,
                          @Qualifier("SearchUserTask") Task<String, List<UserEntity>> searchUserTask) {
        addTask(validateSearchRqTask, false);
        addTask(searchUserTask, true);
    }
}
