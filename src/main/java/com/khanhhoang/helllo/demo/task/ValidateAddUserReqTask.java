package com.khanhhoang.helllo.demo.task;


import com.khanhhoang.helllo.demo.msg.AddUserRequest;
import com.khanhhoang.helllo.task.AbstractTask;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@Qualifier("ValidateAddUserReqTask")
@Async
@Slf4j
public class ValidateAddUserReqTask extends AbstractTask<AddUserRequest> {
    @Override
    public void behaviors(AddUserRequest request) {
        try {
            log.info("Slepping");
            Thread.sleep(10000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        log.info("Validate gi đó, coi như pass");
    }
}
