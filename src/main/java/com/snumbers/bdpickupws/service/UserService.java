package com.snumbers.bdpickupws.service;

import com.snumbers.bdpickupws.shared.dto.UserDashBoardDto;

public interface UserService {

    UserDashBoardDto getUserDashBoard(String userId);
}
