package com.example.doan2.Dto;

import lombok.Data;

import java.util.Date;

@Data
public class TokenDto {
    private  int id;
    private String confirmToken;
    private Date date;
    private int userId;
}
