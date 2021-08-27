package com.khanhhoang.helllo.service.imp;

import com.khanhhoang.helllo.model.UserEntity;
import com.khanhhoang.helllo.repository.UserRepository;
import com.khanhhoang.helllo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserRepository userRepository;

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
