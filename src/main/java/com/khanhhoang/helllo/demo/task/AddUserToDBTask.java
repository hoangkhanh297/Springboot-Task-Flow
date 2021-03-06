package com.khanhhoang.helllo.demo.task;

import com.khanhhoang.helllo.base.data.ResultCode;
import com.khanhhoang.helllo.demo.msg.AddUserRequest;
import com.khanhhoang.helllo.model.RoleEntity;
import com.khanhhoang.helllo.model.UserEntity;
import com.khanhhoang.helllo.msg.Delegate;
import com.khanhhoang.helllo.repository.RoleRepository;
import com.khanhhoang.helllo.repository.UserRepository;
import com.khanhhoang.helllo.task.AbstractTask;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Qualifier("AddUserToDBTask")
@Slf4j
public class AddUserToDBTask extends AbstractTask<AddUserRequest, UserEntity> {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;


    @Override
    protected void behaviors(AddUserRequest request, Delegate<UserEntity> delegate) throws Exception {
        log.info("Add user");
        if (userRepository.existsByUsername(request.getUsername())) {
            log.error("Username {} already in used", request.getUsername());
            delegate.fail(ResultCode.User.USERNAME_ALREADY_EXISTS);
            return;
        }
        var user = new UserEntity();
        user.setName(request.getName());
        user.setStatus(request.getStatus());
        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());
        Set<RoleEntity> roles = new HashSet<>();
        request.getRoles().forEach(value -> {
            var role = roleRepository.findByName(value);
            roles.add(role != null ? role : new RoleEntity(value));
        });
        user.setRoles(roles);
        delegate.getResponse().setData(user);
        log.info("Add user response {}", delegate.getResponse());
    }
}
