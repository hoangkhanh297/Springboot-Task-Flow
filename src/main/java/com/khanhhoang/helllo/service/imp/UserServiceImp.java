package com.khanhhoang.helllo.service.imp;

import com.khanhhoang.helllo.model.UserEntity;
import com.khanhhoang.helllo.repository.UserRepository;
import com.khanhhoang.helllo.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

    private final UserRepository userRepository;

    public UserServiceImp(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<UserEntity> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public List<UserEntity> getUserByName(String name) {
        return userRepository.findByName(name);
    }

    @Override
    public UserEntity addUser(UserEntity userEntity) {
        return userRepository.save(userEntity);
    }
}
