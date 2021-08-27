package com.khanhhoang.helllo.demo.task;

import com.khanhhoang.helllo.demo.msg.GetAllUserRequest;
import com.khanhhoang.helllo.demo.msg.GetAllUserResponse;
import com.khanhhoang.helllo.task.AbstractTask;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("ValidateGetAllUserReqTask")
public class ValidateGetAllUserReqTask extends AbstractTask<GetAllUserRequest, GetAllUserResponse> {
    @Override
    public void behaviors(GetAllUserRequest request, GetAllUserResponse response) {
        log.info("Validate");
    }
}