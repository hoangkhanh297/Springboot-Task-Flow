package com.khanhhoang.helllo.demo.task;

import com.khanhhoang.helllo.demo.msg.AddUserRequest;
import com.khanhhoang.helllo.demo.msg.AddUserResponse;
import com.khanhhoang.helllo.task.AbstractTask;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("ValidateAddUserReqTask")
public class ValidateAddUserReqTask extends AbstractTask<AddUserRequest, AddUserResponse> {
    @Override
    public void behaviors(AddUserRequest request, AddUserResponse response) {
        if (request.getName() == null){
            log.error("Name null");
            request.fail(1);
            return;
        }
        log.info("Validate gi đó, coi như pass");
    }
}
