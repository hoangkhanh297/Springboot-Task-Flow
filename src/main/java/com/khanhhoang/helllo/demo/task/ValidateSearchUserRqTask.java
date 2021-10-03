package com.khanhhoang.helllo.demo.task;

import com.khanhhoang.helllo.demo.msg.SearchUserRequest;
import com.khanhhoang.helllo.task.AbstractTask;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("ValidateSearchRqTask")
public class ValidateSearchUserRqTask extends AbstractTask<SearchUserRequest> {
    @Override
    protected void behaviors(SearchUserRequest request) throws Exception {

    }
}
