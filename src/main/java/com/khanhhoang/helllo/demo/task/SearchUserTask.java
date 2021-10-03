package com.khanhhoang.helllo.demo.task;

import com.khanhhoang.helllo.demo.msg.SearchUserRequest;
import com.khanhhoang.helllo.repository.UserRepository;
import com.khanhhoang.helllo.task.AbstractTask;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("SearchUserTask")
@Slf4j
public class SearchUserTask extends AbstractTask<SearchUserRequest> {

    @Autowired
    private UserRepository userRepository;

    @Override
    protected void behaviors(SearchUserRequest request) throws Exception {
        var users = userRepository.search(request.getText());
        request.setResponse(users);
    }
}
