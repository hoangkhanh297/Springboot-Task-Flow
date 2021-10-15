package com.khanhhoang.helllo.demo.task;

import com.khanhhoang.helllo.model.UserEntity;
import com.khanhhoang.helllo.msg.Delegate;
import com.khanhhoang.helllo.task.AbstractTask;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Qualifier("ValidateGetAllUserReqTask")
@Slf4j
public class ValidateGetAllUserReqTask extends AbstractTask<Object, List<UserEntity>> {

    @Override
    protected void behaviors(Object request, Delegate<List<UserEntity>> delegate) throws Exception {
        delegate.addExtra("Haha", new UserEntity());
        log.info("Validate");
    }
}
