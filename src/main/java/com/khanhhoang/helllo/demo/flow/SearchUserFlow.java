package com.khanhhoang.helllo.demo.flow;

import com.khanhhoang.helllo.demo.msg.SearchUserRequest;
import com.khanhhoang.helllo.flow.AbstractFlow;
import com.khanhhoang.helllo.task.Task;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("SearchUserFlow")
public class SearchUserFlow extends AbstractFlow<SearchUserRequest> {
    public SearchUserFlow(@Qualifier("ValidateSearchRqTask") Task<SearchUserRequest> validateSearchRqTask,
                          @Qualifier("SearchUserTask") Task<SearchUserRequest> searchUserTask) {
        addTask(validateSearchRqTask, false);
        addTask(searchUserTask, true);
    }
}
