package com.snumbers.pickupws.ui.model.response;

import lombok.Data;

@Data
public class UserLoginRequestModel {
    private String username;
    private String password;
}
