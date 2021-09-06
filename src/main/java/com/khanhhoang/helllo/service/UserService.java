package com.khanhhoang.helllo.service;


import com.khanhhoang.helllo.model.UserEntity;

import java.util.List;

public interface UserService {
    List<UserEntity> getUsers();

    List<UserEntity> getUserByName(String name);

    UserEntity addUser(UserEntity userEntity);
}
