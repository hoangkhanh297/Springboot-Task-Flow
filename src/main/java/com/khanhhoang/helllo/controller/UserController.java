package com.khanhhoang.helllo.controller;

import com.khanhhoang.helllo.base.data.ResponseData;
import com.khanhhoang.helllo.demo.msg.AddUserRequest;
import com.khanhhoang.helllo.model.UserEntity;
import com.khanhhoang.helllo.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@Tag(name = "DO NOT CALL THIS API", description = "Đừng gọi API này.!!!! Đây là API dùng để migrate DATA")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/auth/users")
    public ResponseData<List<UserEntity>> getUsers() {
        return userService.getAll();
    }

    @GetMapping("/auth/user/search")
    public ResponseData<List<UserEntity>> search(@RequestParam("keyword") String keyword) {
        return userService.search(keyword);
    }

    @PostMapping("/admin/user")
    @Operation(security = {@SecurityRequirement(name = "Authorization")}, description = "Do not call")
    public ResponseData<UserEntity> addUser(@RequestBody AddUserRequest addUserRequest) {
        return userService.add(addUserRequest);
    }

}
