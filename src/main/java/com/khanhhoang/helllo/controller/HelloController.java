package com.khanhhoang.helllo.controller;

import com.khanhhoang.helllo.demo.msg.AddUserRequest;
import com.khanhhoang.helllo.demo.msg.AddUserResponse;
import com.khanhhoang.helllo.dto.UserDto;
import com.khanhhoang.helllo.flow.Flow;
import com.khanhhoang.helllo.demo.msg.GetAllUserRequest;
import com.khanhhoang.helllo.model.UserEntity;
import com.khanhhoang.helllo.demo.msg.GetAllUserResponse;
import com.khanhhoang.helllo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HelloController {

    @Autowired
    private  UserService userService;

    private final Flow<GetAllUserRequest, GetAllUserResponse> getAllUserFlow;
    private final Flow<AddUserRequest, AddUserResponse> addUserFlow;

    public HelloController(@Qualifier("GetAllUsersFlow") Flow<GetAllUserRequest, GetAllUserResponse> getAllUserFlow,
                           @Qualifier("AddUserFlow") Flow<AddUserRequest, AddUserResponse> addUserFlow) {
        this.getAllUserFlow = getAllUserFlow;
        this.addUserFlow = addUserFlow;
    }

    @GetMapping("/users")
    public Object getUsers() {
        var testMsg = new GetAllUserRequest();
        var testResp = new GetAllUserResponse();
        getAllUserFlow.run(testMsg, testResp);
        return testResp;
    }

    @GetMapping("/user/search")
    public List<UserEntity> getUser(@RequestParam("name") String name) {
        return userService.getUserByName(name);
    }

    @PostMapping("/user")
    public AddUserResponse addUser(@RequestBody AddUserRequest addUserRequest) {
        var addUserResponse = new AddUserResponse();
        addUserFlow.run(addUserRequest, addUserResponse);
        return addUserResponse;
    }


}
