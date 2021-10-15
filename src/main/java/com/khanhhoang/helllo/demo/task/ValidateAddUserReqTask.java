package com.khanhhoang.helllo.demo.task;


import com.khanhhoang.helllo.base.data.ResultCode;
import com.khanhhoang.helllo.demo.msg.AddUserRequest;
import com.khanhhoang.helllo.model.UserEntity;
import com.khanhhoang.helllo.msg.Delegate;
import com.khanhhoang.helllo.task.AbstractTask;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@Qualifier("ValidateAddUserReqTask")
@Async
@Slf4j
public class ValidateAddUserReqTask extends AbstractTask<AddUserRequest, UserEntity> {

    @Override
    protected void behaviors(AddUserRequest request, Delegate<UserEntity> delegate) throws Exception {
        try {
            log.info("Slepping");
            Thread.sleep(10000);
        } catch (Exception e) {
            e.printStackTrace();
            delegate.fail(ResultCode.SYSTEM_ERROR);
        }
        log.info("Validate gi đó, coi như pass");
    }
}
