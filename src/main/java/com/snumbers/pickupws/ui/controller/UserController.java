package com.snumbers.pickupws.ui.controller;

import com.snumbers.pickupws.service.UserService;
import com.snumbers.pickupws.shared.dto.UserDashBoardDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
