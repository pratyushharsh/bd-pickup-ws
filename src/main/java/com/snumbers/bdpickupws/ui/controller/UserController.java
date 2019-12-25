package com.snumbers.bdpickupws.ui.controller;

import com.snumbers.bdpickupws.service.UserService;
import com.snumbers.bdpickupws.shared.dto.UserDashBoardDto;
import com.snumbers.bdpickupws.ui.model.request.UserDetailRequestModel;
import com.snumbers.bdpickupws.ui.model.response.UserDetailResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;

@RestController
@RequestMapping("users")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/{userid}")
    public UserDashBoardDto getUser(@PathVariable("userid") String userid) {
        return userService.getUserDashBoard(userid);
    }
}
