package com.example.doan2.Dto;

import lombok.Data;

@Data
public class UserDto {
    private  Integer userId;
    private  String userName;
    private  String userRole;
    private boolean userEnable;
    private  String userEmail;
    private String  userPassword;
}
