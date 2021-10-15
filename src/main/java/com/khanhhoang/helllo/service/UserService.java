package com.khanhhoang.helllo.service;

import com.khanhhoang.helllo.base.data.ResponseData;
import com.khanhhoang.helllo.demo.flow.GetAllUsersFlow;
import com.khanhhoang.helllo.demo.msg.AddUserRequest;
import com.khanhhoang.helllo.flow.Flow;
import com.khanhhoang.helllo.model.UserEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class UserService {

    @Autowired
    private GetAllUsersFlow getAllUserFlow;
    @Autowired
    @Qualifier("AddUserFlow")
    private Flow<AddUserRequest, UserEntity> addUserFlow;
    @Autowired
    @Qualifier("SearchUserFlow")
    private Flow<String, List<UserEntity>> searchUserFlow;

    public ResponseData<List<UserEntity>> getAll() {
        //Can change to return getAllUserFlow.run(null);
        return getAllUserFlow.run();
    }

    public ResponseData<UserEntity> add(AddUserRequest request) {
        return addUserFlow.run(request);
    }

    public ResponseData<List<UserEntity>> search(String keyword) {
        return searchUserFlow.run(keyword);
    }
}
