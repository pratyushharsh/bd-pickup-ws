package com.snumbers.pickupws.service;

import com.snumbers.pickupws.shared.dto.UserDashBoardDto;

public interface UserService {

    UserDashBoardDto getUserDashBoard(String userId);
}
