package com.snumbers.bdpickupws.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserEntity implements Serializable {
    String userId;
    String firstname;
    String lastname;

}
