package com.khanhhoang.helllo.demo.task;

import com.khanhhoang.helllo.model.UserEntity;
import com.khanhhoang.helllo.msg.Delegate;
import com.khanhhoang.helllo.task.AbstractTask;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Qualifier("ValidateSearchRqTask")
@Slf4j
public class ValidateSearchUserRqTask extends AbstractTask<String, List<UserEntity>> {

    @Override
    protected void behaviors(String text, Delegate<List<UserEntity>> delegate) throws Exception {
        log.info("Validate search request");
    }
}
