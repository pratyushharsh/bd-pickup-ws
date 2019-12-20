package com.snumbers.bdpickupws.shared.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserDto implements Serializable {
    String userId;
    String firstname;
    String lastname;

}
