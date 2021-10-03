package com.khanhhoang.helllo.demo.task;

import com.khanhhoang.helllo.demo.msg.GetAllUserRequest;
import com.khanhhoang.helllo.repository.UserRepository;
import com.khanhhoang.helllo.task.AbstractTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("GetAllUserFromDBTask")
public class GetAllUserFromDBTask extends AbstractTask<GetAllUserRequest> {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void behaviors(GetAllUserRequest request) {
        request.setResponse(userRepository.findAll());
    }
}
