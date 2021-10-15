package com.khanhhoang.helllo.demo.task;

import com.khanhhoang.helllo.model.UserEntity;
import com.khanhhoang.helllo.msg.Delegate;
import com.khanhhoang.helllo.repository.UserRepository;
import com.khanhhoang.helllo.task.AbstractTask;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Qualifier("SearchUserTask")
@Slf4j
@RequiredArgsConstructor
public class SearchUserTask extends AbstractTask<String, List<UserEntity>> {

    @NonNull
    private final UserRepository userRepository;

    @Override
    protected void behaviors(String text, Delegate<List<UserEntity>> delegate) throws Exception {
        var users = userRepository.fullTextSearchUsernameAndName(text);
        delegate.setResponseData(users);
    }
}
