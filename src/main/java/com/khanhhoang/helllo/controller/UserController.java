package com.khanhhoang.helllo.controller;

import com.khanhhoang.helllo.base.data.ResponseData;
import com.khanhhoang.helllo.demo.msg.AddUserRequest;
import com.khanhhoang.helllo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/api")
public class UserController {


    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public Object getUsers() {
        return userService.getAll();
    }

    @GetMapping("/user/search")
    public ResponseData<?> search(@RequestParam("keyword") String keyword) {
        return userService.search(keyword);
    }

    @PostMapping("/user")
    @PreAuthorize("!hasAuthority('ROLE_ADMIN')")
    public ResponseData<?> addUser(@RequestBody AddUserRequest addUserRequest) {
        return userService.add(addUserRequest);
    }

}
