package com.khanhhoang.helllo.demo.task;

import com.khanhhoang.helllo.demo.msg.AddUserRequest;
import com.khanhhoang.helllo.model.RoleEntity;
import com.khanhhoang.helllo.model.UserEntity;
import com.khanhhoang.helllo.model.UserRoleEntity;
import com.khanhhoang.helllo.repository.RoleRepository;
import com.khanhhoang.helllo.repository.UserRepository;
import com.khanhhoang.helllo.repository.UserRoleRepository;
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
public class AddUserToDBTask extends AbstractTask<AddUserRequest> {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserRoleRepository userRoleRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public void behaviors(AddUserRequest request) throws Exception {
        log.info("Add user");
        var user = new UserEntity();
        user.setName(request.getName());
        user.setStatus(request.getStatus());
        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());
        user = userRepository.save(user);

        Set<UserRoleEntity> roles = new HashSet<>();
        for (var role : request.getRoles()) {
            var roleEntities = roleRepository.findByName(role);
            if (roleEntities == null) {
                roleEntities = roleRepository.save(new RoleEntity(role));
            }
            roles.add(new UserRoleEntity(user.getUserId(), roleEntities.getRoleId()));
        }
        userRoleRepository.saveAll(roles);
        log.info("Add user");
        request.setResponse(user);
    }
}
