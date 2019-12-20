package com.snumbers.bdpickupws.ui.controller;

import com.snumbers.bdpickupws.ui.model.request.UserDetailRequestModel;
import com.snumbers.bdpickupws.ui.model.response.UserDetailResponseModel;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;

@RestController
@RequestMapping("users")
public class UserController {

    @GetMapping
    public String getUser() {
        return "Get user called";
    }

    @PostMapping
    public UserDetailResponseModel createUser(@RequestBody UserDetailRequestModel user) {
        return new UserDetailResponseModel();
    }
}
