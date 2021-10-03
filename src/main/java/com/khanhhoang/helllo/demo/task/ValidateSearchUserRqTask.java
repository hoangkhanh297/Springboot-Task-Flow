package com.khanhhoang.helllo.demo.task;

import com.khanhhoang.helllo.demo.msg.SearchUserRequest;
import com.khanhhoang.helllo.task.AbstractTask;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("ValidateSearchRqTask")
@Slf4j
public class ValidateSearchUserRqTask extends AbstractTask<SearchUserRequest> {
    @Override
    protected void behaviors(SearchUserRequest request) throws Exception {

    }
}
