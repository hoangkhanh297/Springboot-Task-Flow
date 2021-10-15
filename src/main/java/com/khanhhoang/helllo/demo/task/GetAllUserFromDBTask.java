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
@Qualifier("GetAllUserFromDBTask")
@Slf4j
@RequiredArgsConstructor
public class GetAllUserFromDBTask extends AbstractTask<Object, List<UserEntity>> {

    @NonNull
    private final UserRepository userRepository;

    @Override
    protected void behaviors(Object request, Delegate<List<UserEntity>> delegate) throws Exception {
        UserEntity user = (UserEntity) delegate.getExtra("Haha");
        log.info("User {}", user);
        delegate.getResponse().setData(userRepository.findAll());
    }
}
